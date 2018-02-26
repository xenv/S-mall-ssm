package tmall.pojo.extension;

import tmall.pojo.Category;
import tmall.pojo.ProductImage;
import tmall.pojo.base.BasePOJO;
import tmall.annotation.ORMAnnotation.JoinColumn;
import tmall.annotation.ORMAnnotation.ManyToOne;
import tmall.annotation.ORMAnnotation.OneToMany;

import java.util.List;

public class ProductExtension extends BasePOJO {

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    @ManyToOne
    @JoinColumn(name="imgid")
    private ProductImage image;
    @OneToMany
    @JoinColumn(name="pid")
    private List<ProductImage> productImages;

    public ProductImage getImage() {
        return image;
    }

    public void setImage(ProductImage image) {
        this.image = image;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
