package tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmall.mapper.ProductMapper;
import tmall.pojo.Product;
import tmall.pojo.ProductExample;
import tmall.service.CommentService;
import tmall.service.OrderItemService;
import tmall.service.OrderService;
import tmall.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper,ProductExample> implements ProductService {

}