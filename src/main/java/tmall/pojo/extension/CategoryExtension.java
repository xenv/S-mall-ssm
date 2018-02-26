package tmall.pojo.extension;

import tmall.pojo.Product;
import tmall.pojo.base.BasePOJO;
import tmall.annotation.ORMAnnotation.JoinColumn;
import tmall.annotation.ORMAnnotation.OneToMany;

import java.util.List;

public class CategoryExtension extends BasePOJO {
    @OneToMany
    @JoinColumn(name = "cid")
    private List<Product> products;


    public String getImgPath() {
        return getId() + ".jpg";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}