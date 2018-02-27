package tmall.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tmall.pojo.Category;
import tmall.service.CategoryService;
import tmall.service.ConfigService;
import tmall.util.Pagination;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
/**
 *  加载搜索栏下面的分类列表
 */
public class CategoryNamesBelowSearchInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    CategoryService categoryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        if (request.getServletContext().getAttribute("cs") != null) {
            return true;
        }
        Pagination pagination = new Pagination();
        pagination.setCount(7);
        List<Category> cs = categoryService
                .list("depth", 1, "pagination", pagination, "recommend_gt", 0);
        request.getServletContext().setAttribute("cs", cs);
        return true;
    }
}
