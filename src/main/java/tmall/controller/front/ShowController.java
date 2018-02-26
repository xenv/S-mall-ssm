package tmall.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tmall.annotation.Nullable;
import tmall.pojo.*;
import tmall.util.Pagination;

import java.util.List;

@Controller
@RequestMapping("/")
public class ShowController extends FrontBaseController {
    @RequestMapping("")
    public String home(Model model) throws Exception {
        Pagination pagination = new Pagination();
        pagination.setCount(13);
        List<Category> categories = categoryService.
                list("depth",1,"pagination",pagination,"recommend_gt",0, "order", "recommend desc, id desc");
        for(Category category:categories){
            category.setProducts(productService
                    .list("cid",category.getId(),"stock_gt",0));
        }
        model.addAttribute("categories",categories);
        return "home";
    }
    @RequestMapping("product")
    public String product(Integer id, Model model) throws Exception {
        Product product = (Product) productService.get(id);
        List<ProductImage> productTopImages = productImageService.list("pid",product.getId(),"type", ProductImage.Type.top.toString(),"order","id asc");
        List<ProductImage> productDetailImages = productImageService.list("pid",product.getId(),"type", ProductImage.Type.detail.toString(),"order","id asc");
        List<Comment> comments = commentService.list("pid",product.getId());
        List<PropertyValue> propertyValues = propertyValueService.list("pid",product.getId());
        model.addAttribute("productTopImages",productTopImages);
        model.addAttribute("productDetailImages",productDetailImages);
        model.addAttribute("comments",comments);
        model.addAttribute("propertyValues",propertyValues);
        model.addAttribute("product",product);
        return "product";
    }
    @RequestMapping("category")
    public String category(Integer id, @Nullable String sort, Model model) throws Exception {
        Category category = (Category) categoryService.get(id);
        List<Product> products = productService
                .list("cid",category.getId(),"order",handleSort(sort),"stock_gt",0);
        model.addAttribute("products",products);
        model.addAttribute("category",category);
        return "category";
    }
    @RequestMapping("search")
    public String search(String keyword, @Nullable String sort, Model model) throws Exception {
        if(keyword.length()==0) {
            return "search";
        }
        List<Product> products = productService
                .list("name_like",keyword,"order",handleSort(sort),"stock_gt",0);
        model.addAttribute("products",products);
        model.addAttribute("keyword",keyword);
        return "search";
    }
    private String handleSort(String sort){
        sort = sort==null?"":sort;
        String column = "";
        String order = "desc";
        switch(sort){
            case "date":
                column = "createDate";
                break;
            case "comment":
                column = "commentCount";
                break;
            case "saleCount":
                column = "saleCount";
                break;
            case "price":
                column = "nowPrice";
                order = "asc";
                break;
            case "priceInverse":
                column = "nowPrice";
                break;
            default:
                column = "commentCount";
                break;
        }
        String res = String.format("%s %s , id desc",column,order);
        return res;
    }
}
