package xyz.mlxkj.myblog_server.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.mlxkj.myblog_server.model.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
