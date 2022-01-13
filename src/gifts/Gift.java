package gifts;

import enums.Category;

public class Gift {
    private String productName;
    private Double price;
    private Category category;

    public Gift(final String productName, final Double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    /**
     * getter
     * @return
     */
    public String getProductName() {
        return productName;
    }

    /**
     * setter
     * @param productName
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * getter
     * @return
     */
    public Double getPrice() {
        return price;
    }

    /**
     * setter
     * @param price
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * getter
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setter
     * @param category
     */
    public void setCategory(final Category category) {
        this.category = category;
    }
}
