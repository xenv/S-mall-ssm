package tmall.interceptor;


import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tmall.annotation.Auth;
import tmall.exception.AuthException;
import tmall.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据注解来鉴权，不指定类注解权限为 0（unLogin），不指定方法注解，权限为类注解权限，
 * 指定方法注解会覆盖掉类注解权限
 * 暂时的权限级为 ： unLogin(0) user(1) admin(2) superAdmin(3)
 * 定义 @Auth() 注解，value值为最低权限的用户组，低于此权限会被禁止访问
 */

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handler = (HandlerMethod) o;
        //获取访问页面的权限

        //获取方法上的注解
        Auth authInMethod = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);

        //获取类上的注解
        Auth authInClass = ((HandlerMethod) handler).getBean().getClass().getAnnotation(Auth.class);
        //获取Enum方法的ordinal，根据大小来确定该页面权限
        int pageRate = authInClass == null ? 0 : authInClass.value().ordinal();
        pageRate = authInMethod == null ? pageRate : authInMethod.value().ordinal();

        //获取用户的权限
        int userRate = 0;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            userRate = user.getGroup().ordinal();
        }

        //根据权限决定是否放行
        if (pageRate > userRate) {
            if (userRate == 0) {
                response.sendRedirect("/login?refer=/");
                return false;
            }
            throw new AuthException("您已登录，但是没有权限访问这里");
        }
        return true;
    }
}
