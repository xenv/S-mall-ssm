package tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tmall.annotation.Auth;
import tmall.annotation.Nullable;
import tmall.pojo.Category;
import tmall.pojo.User;
import tmall.util.Pagination;
import tmall.util.UploadedImageFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController extends AdminBaseController {
    @Auth(User.Group.admin)
    @RequestMapping("list")
    public String list(Model model, Pagination pagination) throws Exception {
        List<Category> categories = categoryService.
                list("pagination", pagination, "order", "recommend desc, id desc");
        model.addAttribute("categories", categories);
        return "admin/listCategory";
    }

    @RequestMapping("add")
    public String add(String name, Integer recommend,
                      UploadedImageFile uploadedImageFile) throws Exception {
        Category c = new Category();
        c.setName(name);
        c.setRecommend(recommend);
        categoryService.add(c);
        fileUtil.saveImg(uploadedImageFile, "category", c.getId() + ".jpg");
        return "redirect:list";
    }

    @Auth(User.Group.admin)
    @RequestMapping("edit")
    public String edit(Integer id, Model model) throws Exception {
        Category category = (Category) categoryService.get(id);
        model.addAttribute(category);
        return "admin/editCategory";
    }

    @RequestMapping("update")
    public String update(Integer id, String name, Integer recommend,
                         @Nullable UploadedImageFile uploadedImageFile, HttpSession session) throws Exception {
        Category c = (Category) categoryService.get(id);
        c.setRecommend(recommend);
        c.setName(name);
        categoryService.update(c);
        if (uploadedImageFile.getImage().getSize() > 0) {
            fileUtil.saveImg(uploadedImageFile, "category", c.getId() + ".jpg");
        }
        //清空搜索栏下的cs缓存
        session.removeAttribute("cs");
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Integer id, HttpSession session) throws Exception {
        categoryService.delete(categoryService.get(id));
        session.removeAttribute("cs");
        return "redirect:list";
    }
}