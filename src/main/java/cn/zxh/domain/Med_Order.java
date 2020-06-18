package cn.zxh.domain;

import org.springframework.web.util.pattern.PathPattern;

import java.io.Serializable;

public class Med_Order implements Serializable {

    private int id;
    private Medicine medicine;
    private int uid;
    private int sid;
    private String createTime;
    private Double Total;
    private int goodsNumber;
    private String userAddress;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", medicine=" + medicine +
                ", uid=" + uid +
                ", sid=" + sid +
                ", createTime='" + createTime + '\'' +
                ", Total=" + Total +
                ", goodsNumber=" + goodsNumber +
                ", userAddress='" + userAddress + '\'' +
                '}'+"\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
