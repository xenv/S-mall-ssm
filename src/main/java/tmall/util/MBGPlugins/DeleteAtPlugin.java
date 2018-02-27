package tmall.util.MBGPlugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * MBG插件 | 使查询支持软删除
 */
public class DeleteAtPlugin extends PluginAdapter {

    @Override
    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        for (Element child : element.getElements()) {
            if (child instanceof XmlElement && ((XmlElement) child).getName().equals("where")) {
                TextElement element1 = new TextElement("and deleteAt is NULL");
                ((XmlElement) child).getElements().add(element1);
                break;
            }
        }
        return true;
    }

    @Override
    public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        TextElement element1 = new TextElement("and deleteAt is NULL");
        element.getElements().add(element1);
        return true;
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }


}
