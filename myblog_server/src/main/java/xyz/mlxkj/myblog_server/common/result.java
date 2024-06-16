package xyz.mlxkj.myblog_server.common;

import lombok.Data;
import java.io.Serializable;

//封装统一的返回结果

@Data
public class result implements Serializable {
    private String Code;
    private String Msg;
    private Object Data;
    public static result succ(Object data) {
        result m = new result();
        m.setCode("0");
        m.setData(data);
        m.setMsg("操作成功");
        return m;
    }
    public static result succ(String mess, Object data) {
        result m = new result();
        m.setCode("0");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }
    public static result fail(String mess) {
        result m = new result();
        m.setCode("-1");
        m.setData(null);
        m.setMsg(mess);
        return m;
    }
    public static result fail(String mess, Object data) {
        result m = new result();
        m.setCode("-1");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }
}
