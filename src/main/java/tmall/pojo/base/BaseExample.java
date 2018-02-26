package tmall.pojo.base;

import tmall.pojo.CartItemExample;

public interface BaseExample {
    Object createCriteria();
    void setOrderByClause(String orderByClause);
}
