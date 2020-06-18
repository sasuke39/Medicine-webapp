package cn.zxh.utils;

/**
 * Created by colors on 2020/5/19.
 */
public class ResultUtil {

    String code;
    String message;
    Object object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResultUtil{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
