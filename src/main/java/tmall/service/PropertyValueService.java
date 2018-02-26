package tmall.service;

import tmall.pojo.Product;
import tmall.pojo.Property;
import tmall.pojo.PropertyValue;

import java.util.List;
import java.util.Map;

public interface PropertyValueService extends BaseService{
    /**
     * 初始化一个产品的所有参数，即预先插入空数据
     * @param product 要修改的产品
     */
    public void init(Product product) throws Exception;
}