package tmall.annotation.ORMAnnotation;
import java.lang.annotation.*;

/**
 * 通用Mapper| ORM配置注解：处理多对一，一对一
 * 加在 Object 变量上面，配合 JoinColumn 使用
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ManyToOne {

}
