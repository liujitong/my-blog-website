package xyz.mlxkj.myblog_server.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@Getter
@Setter
@Data
@TableName("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    @TableField("username")
    private String username;

    @TableField("pwd")
    private String pwd;

    @TableField("mail")
    private String mail;

    @TableField("url")
    private String url;

    @TableField("screenName")
    private String screenName;

    @TableField("_group")
    private String group;
}
