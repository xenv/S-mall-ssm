package tmall.service.impl;

import org.springframework.stereotype.Service;
import tmall.mapper.OrderItemMapper;
import tmall.pojo.OrderItemExample;
import tmall.service.OrderItemService;

@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemMapper,OrderItemExample>
        implements OrderItemService {
 
}