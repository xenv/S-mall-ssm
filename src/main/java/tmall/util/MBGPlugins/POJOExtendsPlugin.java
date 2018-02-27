package tmall.util.MBGPlugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;
import java.util.Properties;
/**
 * MBG插件 | 使 POJO 继承 BasePOJO 类
 */
public class POJOExtendsPlugin extends PluginAdapter {
    private String POJO;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String POJO = this.properties.getProperty("POJO");
        if (StringUtility.stringHasValue(POJO)) {
            this.POJO = POJO;
        } else {
            throw new RuntimeException("POJO插件缺少必要的pojo属性!");
        }
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        FullyQualifiedJavaType mapperType = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
        // import接口
        topLevelClass.addImportedType(mapperType);
        topLevelClass.addSuperInterface(new FullyQualifiedJavaType(
                POJO + "<" + mapperType.getShortName() + ">"
        ));
        return true;
    }


    @Override
    public boolean validate(List<String> list) {
        return true;
    }


}
