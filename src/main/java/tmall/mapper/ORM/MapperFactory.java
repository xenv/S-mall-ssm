package tmall.mapper.ORM;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
