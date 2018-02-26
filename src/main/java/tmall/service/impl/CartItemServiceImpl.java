package tmall.service.impl;

import org.springframework.stereotype.Service;
import tmall.mapper.CartItemMapper;
import tmall.pojo.CartItemExample;
import tmall.service.CartItemService;
import tmall.service.PropertyService;

@Service
public class CartItemServiceImpl extends BaseServiceImpl<CartItemMapper,CartItemExample>
        implements CartItemService {
 
}