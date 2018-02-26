package tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmall.mapper.PropertyValueMapper;
import tmall.pojo.*;
import tmall.service.PropertyService;
import tmall.service.PropertyValueService;

import java.util.List;

@Service
public class PropertyValueServiceImpl extends BaseServiceImpl<PropertyValueMapper, PropertyValueExample>
        implements PropertyValueService {

    @Autowired
    PropertyService propertyService;

    @Override
    public void init(Product product) throws Exception {
        List<Property> properties = propertyService.list("cid", product.getCategory().getId());
        for (Property property : properties) {
            try {
                PropertyValue value = (PropertyValue) list("ptid", property.getId(),
                        "pid", product.getId()).get(0);
            } catch (Exception e) {
                //对应字段为空
                PropertyValue propertyValue = new PropertyValue();
                propertyValue.setValue("");
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                add(propertyValue);
            }
        }

    }
}