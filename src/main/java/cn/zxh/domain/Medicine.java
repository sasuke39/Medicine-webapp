package cn.zxh.domain;

import java.io.Serializable;


public class Medicine implements Serializable {


    private Integer id;
    private String product_name;
    private String img_url;
    private Double cover_price;
    private String details;
    private String type;

    @Override
    public String toString() {
        return "Medicine{" +
                "product_id=" + id +
                ", product_name='" + product_name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", cover_price=" + cover_price +
                ", details='" + details + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getProduct_id() {
        return id;
    }

    public void setProduct_id(Integer product_id) {
        this.id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Double getCover_price() {
        return cover_price;
    }

    public void setCover_price(Double cover_price) {
        this.cover_price = cover_price;
    }

}
