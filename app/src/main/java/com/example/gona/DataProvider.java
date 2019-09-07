package com.example.gona;

public class DataProvider {


    public DataProvider(int img_res, String f_name, String price){
        this.setImg_res(img_res);
        this.setF_name(f_name);
        this.setPrice(price);
    }
    private int img_res;
    private String f_name, price;

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
