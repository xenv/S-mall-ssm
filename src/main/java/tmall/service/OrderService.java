package tmall.service;

import tmall.pojo.CartItem;
import tmall.pojo.Order;
import tmall.pojo.User;
import tmall.service.BaseService;

import java.util.List;

public interface OrderService extends BaseService{
    /**
     * 添加订单
     */
    public void createOrder(Order order ,List<CartItem> cartItems) throws Exception;
}