package tmall.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tmall.service.ProductService;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductTest extends AbstractJUnit4SpringContextTests {
    @Resource
    ProductService productService;

    @Test
    public void getProduct() throws Exception {
        productService.get(5);
        System.out.println("test");
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource(""));
    }
}
