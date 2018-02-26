package tmall.annotation;


import tmall.pojo.User;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD,TYPE})
@Inherited
public @interface Auth {
    User.Group value();
}
