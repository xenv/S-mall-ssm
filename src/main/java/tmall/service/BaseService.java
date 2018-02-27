package tmall.service;

import tmall.pojo.base.BasePOJO;

import java.util.List;

/**
 * 服务层抽象类，封装了大部分的服务层代码，普通Service需继承本类使用
 * list方法和total方法的调用比较特别，需要注意
 */
public interface BaseService extends Service4DAO {
    /**
     * @param object 要添加的数据
     * @return 影响的行数（可判断有无插进）
     */
    public Integer add(BasePOJO object) throws Exception;

    /**
     * @param object 要更新的数据
     */
    public void update(BasePOJO object) throws Exception;

    /**
     * 更新一个列表，适用于一次性更改多个对象，并且每个对象只传入一个新值的情况
     * 例：configService.update(list,"value")，
     * 将会逐个遍历list的每个config对象，从数据库读取原有数据，将value属性的新值插入原有数据，并更新
     *
     * @param changeFiledName 新值的字段
     */
    public void update(Integer[] ids, String[] values, String changeFiledName) throws Exception;

    /**
     * 本方法会自动调用该对象的setDeleteAt方法，向数据库中插入deleteAt日期并更新，不会真的删除数据库中的数据
     *
     * @param object 要删除的对象
     */
    public void delete(BasePOJO object) throws Exception;

    ;

    /**
     * @param clazz 指定一个表，形式为pojo的类对象
     * @param id    要获取的id
     * @return 指定表，指定id的一行
     */
    public BasePOJO get(Class clazz, int id) throws Exception;


    /**
     * @param id 数据库中的id
     * @return 自动识别表的id的一行数据
     */
    public BasePOJO get(int id) throws Exception;

    /**
     * @param id    数据库中的id
     * @param depth 遍历填充的深度
     * @return 自动识别表的id的一行数据
     */
    public BasePOJO get(int id, int depth) throws Exception;

    /**
     * @param paramAndObjects (propertyName,object,propertyName,object....)
     *                        例子：productService调用 list("cid",category.getId()) ,可获取所有该分类的 products
     *                        可堆叠使用，UserService 调用 list("name","xxx","password","xxx")可获取符合条件的 user
     *                        支持多条件查询的功能
     *                        order, String                 指定order
     *                        xx, String                    xx列 = String
     *                        xx_like, String               xx列 like String
     *                        xx_gt, int                    xx列 > int
     *                        pagination,paginationObj      处理分页
     *                        depth, int                    通用 mapper 递归 填充的深度
     * @return 加查询约束的列表
     * @see tmall.service.impl.BaseServiceImpl
     */
    public List list(Object... paramAndObjects) throws Exception;

    /**
     * @param paramAndObjects 同上
     * @return 只返回第一个
     */
    public Object getOne(Object... paramAndObjects);


}