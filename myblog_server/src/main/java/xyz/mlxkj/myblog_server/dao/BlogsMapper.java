package xyz.mlxkj.myblog_server.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.mlxkj.myblog_server.model.Blogs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@Mapper
public interface BlogsMapper extends BaseMapper<Blogs> {

}
