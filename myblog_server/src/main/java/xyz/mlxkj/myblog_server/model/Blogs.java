package xyz.mlxkj.myblog_server.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@Data
@Getter
@Setter
@TableName("blogs")
public class Blogs implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客id
     */
    @TableId(value = "bid", type = IdType.AUTO)
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
    @TableField("descp")
    private String descp;

    /**
     * 文章内容
     */
    @TableField("content")
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm")
    @TableField("created")
    private LocalDateTime created;
}
