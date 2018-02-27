package tmall.annotation.ORMAnnotation;
import java.lang.annotation.*;

/**
 * 通用Mapper| ORM配置注解：Enum处理
 * 加在 Enum 变量上面，指定 var 为从数据库读出的，String类型的，变量
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Enumerated {
    String var();
}
