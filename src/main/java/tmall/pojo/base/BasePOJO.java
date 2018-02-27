package tmall.pojo.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 让 mybatis-generator 自动生成的 pojo 自动继承本类
 */

public class BasePOJO implements Serializable {
    private Integer id;
    private Date deleteAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }
}
