package tmall.util.MBGPlugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;
import java.util.Properties;
/**
 * MBG插件 | 使 Example 继承 BaseExample
 */
public class ExampleExtendsPlugin extends PluginAdapter {
    private String example;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String example = this.properties.getProperty("example");
        if (StringUtility.stringHasValue(example)) {
            this.example = example;
        } else {
            throw new RuntimeException("example插件缺少必要的example属性!");
        }
    }


    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        // import接口
        topLevelClass.addImportedType(example);
        topLevelClass.addSuperInterface(new FullyQualifiedJavaType(
                example
        ));
        return true;
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }


}
