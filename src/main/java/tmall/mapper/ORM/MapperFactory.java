package tmall.mapper.ORM;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *  通用 Mapper | 给 Service 调用的 工厂 函数，会自动加载相应的 mapper，并且交由通用 mapper 处理
 */

@Component
public class MapperFactory {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @SuppressWarnings("unchecked")
    public Mapper getMapper(Class mapperInterface) throws Exception {
        Mapper mapper = new Mapper();
        mapper.setSqlSessionTemplate(sqlSessionTemplate);
        mapper.setMybatisMapper(mapperInterface);
        return mapper;
    }
}
