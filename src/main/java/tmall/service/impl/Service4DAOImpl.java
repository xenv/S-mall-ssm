package tmall.service.impl;


import org.springframework.beans.factory.InitializingBean;


import tmall.mapper.ORM.Mapper;
import tmall.mapper.ORM.MapperFactory;
import tmall.pojo.base.BaseExample;
import tmall.service.Service4DAO;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;


/**
 * Service层处理dao层的基类，通过反射获取 实际业务子类的名称，拉取相应的 pojo类、mapper类和 Example 类
 * 代理 createCriteria方法和 getSession方法
 */

public class Service4DAOImpl<M, E> implements Service4DAO, InitializingBean {

    @Resource
    private MapperFactory mapperFactory;

    Mapper mapper;

    @Override
    /*
    加载完 Service 后执行，获取对应 Service 和 Mapper
     */
    public void afterPropertiesSet() throws Exception {
        mapper = getMapper();
    }

    public Mapper getMapper() throws Exception {
        // 读取泛型第一个 M 的类型，
        ParameterizedType t = (ParameterizedType) (getClass().getGenericSuperclass());
        Class mapperClass = null;
        if (t != null) {
            mapperClass = (Class) t.getActualTypeArguments()[0];
        }
        return getMapper(mapperClass);
    }

    public Mapper getMapper(Class mapperInterface) throws Exception {
        return mapperFactory.getMapper(mapperInterface);
    }

    public BaseExample getExample() throws Exception {
        ParameterizedType t = (ParameterizedType) (getClass().getGenericSuperclass());
        Class exampleClass = null;
        if (t != null) {
            exampleClass = (Class) t.getActualTypeArguments()[1];
        }
        return (BaseExample) exampleClass.newInstance();
    }
}
