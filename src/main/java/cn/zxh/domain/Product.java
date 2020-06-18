package cn.zxh.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer pro_id;
    private String pro_name;
    private String pro_type;
    private String pro_information;
    private double pro_price;
    private String pro_img_src;

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_type() {
        return pro_type;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type;
    }

    public String getPro_information() {
        return pro_information;
    }

    public void setPro_information(String pro_information) {
        this.pro_information = pro_information;
    }

    public double getPro_price() {
        return pro_price;
    }

    public void setPro_price(double pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_img_src() {
        return pro_img_src;
    }

    public void setPro_img_src(String pro_img_src) {
        this.pro_img_src = pro_img_src;
    }

    @Override
    public String toString() {
        return "product{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", pro_type='" + pro_type + '\'' +
                ", pro_information='" + pro_information + '\'' +
                ", pro_price=" + pro_price +
                ", pro_img_src='" + pro_img_src + '\'' +
                '}';
    }
}
