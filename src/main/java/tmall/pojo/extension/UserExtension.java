package tmall.pojo.extension;

import tmall.pojo.base.BasePOJO;
import tmall.annotation.ORMAnnotation.Enumerated;

public class UserExtension extends BasePOJO  {
    @Enumerated(var = "group_")
    private Group group;

    public Group getGroup(){
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public enum Group{
        unLogin,user,admin,superAdmin;
    }
}
