package tmall.service.impl;


import org.springframework.stereotype.Service;


import tmall.mapper.CategoryMapper;
import tmall.pojo.Category;
import tmall.pojo.CategoryExample;
import tmall.pojo.ProductExample;
import tmall.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * @see CategoryService
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper,CategoryExample>
        implements CategoryService  {

}