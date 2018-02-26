package tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tmall.annotation.Auth;
import tmall.pojo.Category;
import tmall.pojo.Product;
import tmall.pojo.User;
import tmall.util.Pagination;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController extends AdminBaseController {
    @Auth(User.Group.admin)
    @RequestMapping("list")
    public String list(Integer cid, Model model, Pagination pagination) throws Exception {
        List<Category> products = productService
                .list("cid", cid, "pagination", pagination);
        Category category = (Category) categoryService.get(cid);
        pagination.setParam("&cid=" + category.getId());
        model.addAttribute("products", products);
        model.addAttribute("category", category);
        return "admin/listProduct";
    }

    @RequestMapping("add")
    public String add(Integer cid, String name, String subTitle,
                      BigDecimal originalPrice, BigDecimal nowPrice, Integer stock) throws Exception {
        Product p = new Product();
        p.setCid(cid);
        p.setName(name);
        p.setSubTitle(subTitle);
        p.setOriginalPrice(originalPrice);
        p.setNowPrice(nowPrice);
        p.setStock(stock);
        p.setCommentCount(0);
        p.setCreateDate(new Date());
        p.setSaleCount(0);

        productService.add(p);
        return "redirect:list?cid=" + cid;
    }

    @Auth(User.Group.admin)
    @RequestMapping("edit")
    public String edit(Integer id, Model model) throws Exception {
        Product p = (Product) productService.get(id);
        model.addAttribute(p);
        return "admin/editProduct";
    }

    @RequestMapping("update")
    public String update(Integer id, String name, String subTitle,
                         BigDecimal originalPrice, BigDecimal nowPrice, Integer stock) throws Exception {

        Product p = (Product) productService.get(id);
        p.setName(name);
        p.setSubTitle(subTitle);
        p.setOriginalPrice(originalPrice);
        p.setNowPrice(nowPrice);
        p.setStock(stock);
        productService.update(p);
        return "redirect:list?cid=" + p.getCategory().getId();
    }

    @RequestMapping("delete")
    public String delete(int id) throws Exception {
        Product p = (Product) productService.get(id);
        productService.delete(p);
        return "redirect:list?cid=" + p.getCategory().getId();
    }
}