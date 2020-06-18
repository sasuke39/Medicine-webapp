package cn.zxh.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CreatUid {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);

        if (!targetFile.exists()) {

            targetFile.mkdirs();

        }

        FileOutputStream out = new FileOutputStream(filePath + "/" + fileName);

        out.write(file);

        out.flush();

        out.close();

    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }
    public static String gettimestr(){
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd" );
        Date d1= new Date();
        String str1 = sdf1.format(d1);
//        System.out.println("当前时间通过 yyyy-MM-dd 格式化后的输出: "+str1);
        return str1;
    }

}
