package cn.zxh.domain;

import java.io.Serializable;

public class Goods implements Serializable {
    int number;
    int sid;
    String  goodName;
    Double OnePrice;
    int id;
    Medicine medicine;

    @Override
    public String toString() {
        return "Goods{" +
                "number=" + number +
                ", sid=" + sid +
                ", goodName='" + goodName + '\'' +
                ", OnePrice=" + OnePrice +
                ", id=" + id +
                ", medicine=" + medicine +
                '}';
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getOnePrice() {
        return OnePrice;
    }

    public void setOnePrice(Double onePrice) {
        OnePrice = onePrice;
    }
}
