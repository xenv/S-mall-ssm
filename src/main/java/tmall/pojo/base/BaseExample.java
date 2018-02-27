package tmall.pojo.base;

/**
 * 让 mybatis-generator 自动生成的 Example 自动实现本接口
 */
public interface BaseExample {
    Object createCriteria();
    void setOrderByClause(String orderByClause);
}
