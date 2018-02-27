package tmall.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

/**
 * 数据校验 | 可空
 * 加在 Controller 的函数 的 参数 前面，本注解代表可空， 其他未写
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({PARAMETER})
public @interface Nullable {

}
