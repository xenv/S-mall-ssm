package tmall.annotation.ORMAnnotation;
import java.lang.annotation.*;

/**
 * 通用Mapper| ORM配置注解：处理一对多
 * 加在 List<Object> 变量上面，配合 JoinColumn 使用
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface OneToMany {

}
