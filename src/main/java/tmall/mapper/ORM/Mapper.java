package tmall.mapper.ORM;

import java.util.List;

/**
 *  通用 Mapper | 对 mapper 的 所有函数进行静态代理，供调用使用
 */

@SuppressWarnings("unchecked")
public class Mapper extends Mapper4ORM {

    private int defaultTraversalDepth = 2;

    public Object selectByPrimaryKey(Integer id) throws Exception {
        return selectByPrimaryKey(id, defaultTraversalDepth);
    }

    public Object selectByPrimaryKey(Integer id, Integer depth) throws Exception {
        Object object = mapper.getClass().getMethod("selectByPrimaryKey", Integer.class).invoke(mapper, id);
        fillOnReading(object, depth);
        return object;
    }

    public int insert(Object object) throws Exception {
        fillOnWriting(object);
        return (int) mapper.getClass().getMethod("insert", object.getClass()).invoke(mapper, object);
    }

    public int insertSelective(Object object) throws Exception {
        fillOnWriting(object);
        return (int) mapper.getClass().getMethod("insertSelective", Object.class).invoke(mapper, object);
    }

    public int updateByPrimaryKeySelective(Object object) throws Exception {
        fillOnWriting(object);
        return (int) mapper.getClass().
                getMethod("updateByPrimaryKeySelective", object.getClass()).invoke(mapper, object);
    }

    public int updateByPrimaryKey(Object object) throws Exception {
        fillOnWriting(object);
        return (int) mapper.getClass().getMethod("updateByPrimaryKey", object.getClass()).invoke(mapper, object);
    }

    public List selectByExample(Object example) throws Exception {
        return selectByExample(example, defaultTraversalDepth);
    }

    public List selectByExample(Object example, int depth) throws Exception {
        List result = (List) mapper.getClass().getMethod("selectByExample", example.getClass()).invoke(mapper, example);
        for (int i = 0; i < result.size(); i++) {
            Object item = result.get(i);
            fillOnReading(item, depth);
            result.set(i, item);
        }
        return result;
    }
}
