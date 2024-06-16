package xyz.mlxkj.myblog_server.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("blogs")
public class Blogs implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客id
     */
    @TableId("bid")
    private Long bid;

    /**
     * 作者id
     */
    @TableField("uid")
    private Long uid;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 摘要
     */
    @TableField("desc")
    private String desc;

    /**
     * 文章内容
     */
    @TableField("content")
    private String content;

    /**
     * 创建时间
     */
    @TableField("created")
    private LocalDateTime created;
}
