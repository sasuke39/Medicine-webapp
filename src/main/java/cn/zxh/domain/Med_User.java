package cn.zxh.domain;

import java.io.Serializable;
import java.util.List;

public class Med_User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String phoneNumber;
    private String user_icon;
    private String createTime;

    private String sex;
    private List<Med_Order> med_orders;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", user_icon='" + user_icon + '\'' +
                ", createTime='" + createTime + '\'' +
                ", sex='" + sex + '\'' +
                ", med_orders=" + med_orders +
                '}';
    }

    public List<Med_Order> getMed_orders() {
        return med_orders;
    }

    public void setMed_orders(List<Med_Order> med_orders) {
        this.med_orders = med_orders;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String creatTime) {
        this.createTime = creatTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }
}
