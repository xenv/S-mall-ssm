package tmall.service.impl;


import org.springframework.stereotype.Service;
import tmall.mapper.ProductImageMapper;
import tmall.pojo.Product;
import tmall.pojo.ProductImage;
import tmall.pojo.ProductImageExample;
import tmall.service.ProductImageService;

import java.util.List;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImageMapper,ProductImageExample>
        implements ProductImageService {

}