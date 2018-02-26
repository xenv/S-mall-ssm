package tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tmall.annotation.Auth;
import tmall.pojo.Category;
import tmall.pojo.Property;
import tmall.pojo.User;
import tmall.util.Pagination;


import java.util.List;

@Controller
@RequestMapping("/admin/property")
public class PropertyController extends AdminBaseController {


    @Auth(User.Group.admin)
    @RequestMapping("list")
    public String list(Integer cid, Model model, Pagination pagination) throws Exception {
        List<Category> properties = propertyService
                .list("cid",cid);
        Category category = (Category) categoryService.get(cid);
        model.addAttribute("properties", properties);
        model.addAttribute("category",category);
        return "admin/listProperties";
    }

    @RequestMapping("add")
    public String add(Integer cid, String name) throws Exception {
        Property p = new Property();
        p.setCid(cid);
        p.setName(name);
        propertyService.add(p);
        return "redirect:list?cid="+cid;
    }
    @Auth(User.Group.admin)
    @RequestMapping("edit")
    public String edit(Integer id, Model model) throws Exception {
        Property property = (Property) propertyService.get(id);
        model.addAttribute(property);
        return "admin/editProperty";
    }

    @RequestMapping("update")
    public String update(Integer id, String name) throws Exception {
        Property p = (Property) productService.get(id);
        p.setName(name);
        propertyService.update(p);
        return "redirect:list?cid="+p.getCategory().getId();
    }

    @RequestMapping("delete")
    public String delete(Integer id) throws Exception {
        Property p = (Property) propertyService.get(id);
        propertyService.delete(p);
        return "redirect:list?cid="+p.getCategory().getId();
    }
}