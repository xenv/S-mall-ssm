package tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tmall.annotation.Auth;
import tmall.pojo.Product;
import tmall.pojo.ProductImage;
import tmall.pojo.User;
import tmall.util.UploadedImageFile;

import java.util.List;

@Controller
@RequestMapping("/admin/product/image")
public class ProductImageController extends AdminBaseController {
    @Auth(User.Group.admin)
    @RequestMapping("list")
    public String list(Integer pid, Model model) throws Exception {
        List<ProductImage> productTopImages = productImageService
                .list("pid", pid, "type", ProductImage.Type.top.toString(),"order","id asc");
        List<ProductImage> productDetailImages = productImageService
                .list("pid", pid, "type", ProductImage.Type.detail.toString(),"order","id asc");
        Product product = (Product) productService.get(pid);
        model.addAttribute("product", product);
        model.addAttribute("productCoverImage", product.getImage());
        model.addAttribute("productTopImages", productTopImages);
        model.addAttribute("productDetailImages", productDetailImages);

        return "admin/listProductImage";
    }

    @RequestMapping("add")
    public String add(Integer pid, String type, UploadedImageFile uploadedImageFile) throws Exception {
        ProductImage productImage = new ProductImage();
        productImage.setPid(pid);
        productImage.setType(type);
        productImageService.add(productImage);
        fileUtil.saveImg(uploadedImageFile, "product", productImage.getId() + ".jpg");
        if (productImage.getType().equals(ProductImage.Type.cover.toString())) {
            Product product = (Product) productService.get(pid);
            product.setImage(productImage);
            productService.update(product);
        }
        return "redirect:list?pid=" + pid;
    }

    @RequestMapping("delete")
    public String delete(Integer id) throws Exception {
        ProductImage productImage = (ProductImage) productImageService.get(id);
        productImageService.delete(productImage);
        return "redirect:list?pid=" + productImage.getProduct().getId();
    }
}