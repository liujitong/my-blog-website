package xyz.mlxkj.myblog_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 作者：刘纪彤
 * @since 2024-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String name;

    private String password;

    private String mail;

    private String url;

    @TableField("screenName")
    private String screenName;

    private String group;


}
