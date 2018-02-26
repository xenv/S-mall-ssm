package tmall.pojo.extension;

import tmall.pojo.OrderItem;
import tmall.pojo.User;
import tmall.pojo.base.BasePOJO;
import tmall.annotation.ORMAnnotation.Enumerated;
import tmall.annotation.ORMAnnotation.JoinColumn;
import tmall.annotation.ORMAnnotation.ManyToOne;
import tmall.annotation.ORMAnnotation.OneToMany;

import java.util.List;

public class OrderExtension extends BasePOJO {
    @ManyToOne
    @JoinColumn(name="uid")
    private User user;
    @Enumerated(var = "status")
    private Status statusEnum;
    @OneToMany
    @JoinColumn(name = "oid")
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getStatusText() {
        return statusEnum.getName();
    }

    public Status getStatusEnum() {
        return statusEnum;
    }

    public void setStatus(Status statusEnum) {
        this.statusEnum = statusEnum;
    }

    public void setStatusEnum(Status statusEnum) {
        this.statusEnum = statusEnum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public enum Status{
        waitPay("待付款"),
        waitDeliver("待发货"),
        waitConfirm("待收货"),
        waitComment("待评论"),
        finish("完成订单"),
        deleted("已删除");

        private String name;

        private Status(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
