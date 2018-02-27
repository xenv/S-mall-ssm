package tmall.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import tmall.annotation.Nullable;
import tmall.exception.ParameterException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

/**
 * 处理数据校验，配合 自定义注解
 * 默认所有参数为空，若可以为空则在 参数前 加注解，其他校验未写
 */

@Aspect
@Component
public class VerificationAspect {
    /**
     * 声明切面 应用在，所有 Controller下的， 以Controller结尾的类中的，所有 public 方法
     */
    @Pointcut("execution(public * tmall.controller.*.*Controller.*(..))")
    public void joinPointInAllController() {
    }

    /**
     * 切入点执行前方法
     *
     * @param point 切入点
     */
    @Before("joinPointInAllController()")
    public void checkParameter(JoinPoint point) throws ParameterException {
        // 获得切入方法参数
        Object[] args = point.getArgs();
        // 获得切入的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        // 获得所有参数
        Parameter[] parameters = method.getParameters();
        // 保存需要校验的args
        ArrayList<Object> argsWithoutNullable = new ArrayList<>();
        // 对没有Nullable注解的参数进行非空校验
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Annotation[] annotations = parameter.getDeclaredAnnotationsByType(Nullable.class);
            if (annotations.length < 1) {
                argsWithoutNullable.add(args[i]);
            }
        }
        for (Object o : argsWithoutNullable) {
            if (o == null) {
                throw new ParameterException("非法请求,参数不全");
            }
        }
    }
}
