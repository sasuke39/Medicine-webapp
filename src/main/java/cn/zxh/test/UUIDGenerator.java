package cn.zxh.test;

import java.util.UUID;

public class UUIDGenerator {


    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }

    public static String getWordName()
    {
        int num = (int) Math.round(Math.random()*90000+1);
        return String.valueOf(num);
    }

    public static void main(String[] args) {
        String abc =  getUUID();
        System.out.println("abc="+abc);
        String cba = getWordName();
        System.out.println(cba);
    }
}

