package com.example.gona;

public class Popular {
    private String product_title, product_price, product_image;

    public Popular() {
    }

    public Popular(String product_title, String product_price, String product_image) {
        this.product_title = product_title;
        this.product_price = product_price;
        this.product_image = product_image;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
}
