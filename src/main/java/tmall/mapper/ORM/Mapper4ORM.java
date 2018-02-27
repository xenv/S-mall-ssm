package tmall.mapper.ORM;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import tmall.pojo.base.BaseExample;
import tmall.annotation.ORMAnnotation.Enumerated;
import tmall.annotation.ORMAnnotation.JoinColumn;
import tmall.annotation.ORMAnnotation.ManyToOne;
import tmall.annotation.ORMAnnotation.OneToMany;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  通用 Mapper | 核心，处理一对多，多对一的插入
 */

@SuppressWarnings("unchecked")
public class Mapper4ORM {
    Object mapper;

    private Class mapperInterface;

    private SqlSessionTemplate sqlSessionTemplate;

    void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    void setMybatisMapper(Class mapperInterface) throws Exception {
        this.mapperInterface = mapperInterface;
        mapper = getMapper(mapperInterface);
    }

    public Object getMapper(Class mapperInterface) throws Exception {
        return sqlSessionTemplate.getMapper(mapperInterface);
    }

    public BaseExample getExample(Class mapperInterface) throws Exception {
        ParameterizedType t = (ParameterizedType) mapperInterface.getGenericInterfaces()[0];
        Class exampleClass = (Class) t.getActualTypeArguments()[1];
        return (BaseExample) exampleClass.newInstance();
    }

    public Class getMapperInterfaceByPOJO(Class POJOClass) throws Exception {
        ParameterizedType t = (ParameterizedType) POJOClass.getGenericInterfaces()[0];
        return (Class) t.getActualTypeArguments()[0];
    }

    /**
     * 获取一个类里的，有指定annotation的，所有 Filed
     *
     * @param objectClass     一个类
     * @param annotationClass 指定的 annotation
     * @return 所有的 Filed
     */
    List<Field> getFieldsEquals(Class objectClass, Class annotationClass) {
        if (objectClass == null) {
            return null;
        }
        List<Field> fields = new ArrayList<>();
        for (Class temp = objectClass; temp != Object.class; temp = temp.getSuperclass()) {
            fields.addAll(Arrays.asList(temp.getDeclaredFields()));
        }
        List<Field> result = new ArrayList<>();
        for (Field field : fields) {
            if (field.getAnnotation(annotationClass) != null)
                result.add(field);
        }
        return result;
    }

    /**
     * 读取时，处理所有 多对一 的填充
     *
     * @param object 被填充的对象
     * @param depth  当前深度
     * @throws Exception 反射异常
     */
    public void fillManyToOneOnReading(Object object, int depth) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFieldsEquals(clazz, ManyToOne.class);
        for (Field field : result) {
            //获取外键的表名
            String joinColumn = field.getAnnotation(JoinColumn.class).name();

            //获取要填充对象的mapper
            Class targetMapperClass = getMapperInterfaceByPOJO(field.getType());
            Object targetMapper = getMapper(targetMapperClass);
            //获取外键值
            Integer joinColumnValue = (Integer) clazz.
                    getMethod("get" + StringUtils.capitalize(joinColumn)).invoke(object);
            if (joinColumnValue == null) {
                continue;
            }
            //配置查询器example
            BaseExample example = getExample(targetMapperClass);
            Object criteria = example.createCriteria();
            // 配置criteria
            criteria.getClass().getMethod("andIdEqualTo", Integer.class).invoke(criteria, joinColumnValue);
            //查询,获取结果列表
            List targetResults = (List) targetMapper.getClass().getMethod("selectByExample", example.getClass()).
                    invoke(targetMapper, example);

            //判断是否为空 ，不为空插入 filed
            if (targetResults.size() > 0) {
                Object targetResult = targetResults.get(0);
                fillOnReading(targetResult, depth - 1);
                clazz.getMethod("set" + StringUtils.capitalize(field.getName()), targetResult.getClass())
                        .invoke(object, targetResult);
            }
        }
    }

    /**
     * 读取时，处理所有 一对多 的填充
     *
     * @param object 被填充的对象
     * @param depth  当前深度
     * @throws Exception 反射异常
     */
    public void fillOneToManyOnReading(Object object, int depth) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFieldsEquals(clazz, OneToMany.class);
        for (Field field : result) {
            //获取外键的表名
            String joinColumn = field.getAnnotation(JoinColumn.class).name();
            //得到其Generic的类型
            Type genericType = field.getGenericType();
            ParameterizedType pt = (ParameterizedType) genericType;
            //得到List泛型里的目标类型对象
            Class targetClass = (Class) pt.getActualTypeArguments()[0];
            //获取要填充对象的mapper
            Class targetMapperClass = getMapperInterfaceByPOJO(targetClass);
            Object targetMapper = getMapper(targetMapperClass);
            //获取外键值
            Integer joinColumnValue = (Integer) clazz.
                    getMethod("getId").invoke(object);
            //配置查询器example
            BaseExample example = getExample(targetMapperClass);
            Object criteria = example.createCriteria();
            // 配置criteria
            criteria.getClass().getMethod("and" + StringUtils.capitalize(joinColumn) + "EqualTo", Integer.class).invoke(criteria, joinColumnValue);
            //查询,获取结果列表
            List targetResults = (List) targetMapper.getClass().getMethod("selectByExample", example.getClass()).
                    invoke(targetMapper, example);
            for (int i = 0; i < targetResults.size(); i++) {
                Object item = targetResults.get(i);
                fillOnReading(item, depth - 1);
                targetResults.set(i, item);
            }
            //插入 filed
            clazz.getMethod("set" + StringUtils.capitalize(field.getName()), List.class)
                    .invoke(object, targetResults);

        }
    }

    /**
     * 读取时，处理所有 Enum 的填充
     *
     * @param object 被填充的对象
     * @throws Exception 反射异常
     */
    public void fillEnumOnReading(Object object) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFieldsEquals(clazz, Enumerated.class);
        for (Field field : result) {
            //获取Enum对应的，String类型的变量名
            String varName = field.getAnnotation(Enumerated.class).var();

            //获取值
            String enumString = (String) clazz.
                    getMethod("get" + StringUtils.capitalize(varName)).invoke(object);

            // 转成Enum，插回 filed
            Enum resultObj = Enum.valueOf((Class<Enum>) field.getType(), enumString);
            clazz.getMethod("set" + StringUtils.capitalize(field.getName()), resultObj.getClass())
                    .invoke(object, resultObj);

        }
    }

    /**
     * 写入时，处理所有 Enum 的填充
     *
     * @param object 被填充的对象
     * @throws Exception 反射异常
     */
    public void fillEnumOnWriting(Object object) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFieldsEquals(clazz, Enumerated.class);
        for (Field field : result) {
            //获取Enum对应的，String类型的变量名
            String varName = field.getAnnotation(Enumerated.class).var();

            //获取 Enum
            Enum enumObj = (Enum) clazz.
                    getMethod("get" + StringUtils.capitalize(field.getName())).invoke(object);

            // 转成 String，插回 varName
            String enumString = enumObj.name();
            clazz.getMethod("set" + StringUtils.capitalize(varName), String.class)
                    .invoke(object, enumString);
        }
    }

    /**
     * 写入时，处理所有 ManyToOne 的填充
     *
     * @param object 被填充的对象
     * @throws Exception 反射异常
     */
    public void fillManyToOneOnWriting(Object object) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFieldsEquals(clazz, ManyToOne.class);
        for (Field field : result) {
            //获取One端的变量名
            String columnName = field.getAnnotation(JoinColumn.class).name();

            //获取One的对象
            Object targetObj = clazz
                    .getMethod("get" + StringUtils.capitalize(field.getName()))
                    .invoke(object);
            if (targetObj == null) {
                continue;
            }
            //获取 获取 id 值
            int id = (int) targetObj.getClass().
                    getMethod("getId").invoke(targetObj);

            // 插回 columnName

            clazz.getMethod("set" + StringUtils.capitalize(columnName), Integer.class)
                    .invoke(object, id);
        }
    }

    /**
     * 读取时填充数据，递归调用上面的方法
     * @param object 对象
     * @param depth 当前递归深度
     * @throws Exception 反射异常
     */
    public void fillOnReading(Object object, int depth) throws Exception {
        if (object == null) {
            return;
        }
        if (depth <= 0) {
            return;
        }

        // 处理 ManyToOne
        fillManyToOneOnReading(object, depth);
        // 处理 OneToMany
        fillOneToManyOnReading(object, depth);
        // 处理 Enumerated
        fillEnumOnReading(object);

    }

    /**
     * 写入时填充数据，递归调用上面的方法
     * @param object 对象
     * @throws Exception 反射异常
     */
    public void fillOnWriting(Object object) throws Exception {
        if (object == null) {
            return;
        }
        // 处理 Enumerated
        fillEnumOnWriting(object);
        // 处理 ManyToOne
        fillManyToOneOnWriting(object);
    }
}
