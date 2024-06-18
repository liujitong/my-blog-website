package xyz.mlxkj.myblog_server.common;

import lombok.Data;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

//登录信息中间层
@Data
public class AccountMsg implements Serializable{

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
