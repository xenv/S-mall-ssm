package tmall.service;


import tmall.mapper.ORM.Mapper;

/**
 * Service层处理dao层的基类，通过反射获取 baseService 子类的实际业务子类的名称，拉取相应的 dao类和 pojo类，
 */

public interface Service4DAO {
    /**
     *
     * @param mapperInterface mapper的接口，不用加地址
     * @return 经过Spring代理过的 mapper
     * @throws Exception 错误
     */
    Mapper getMapper(Class mapperInterface) throws Exception;
}
