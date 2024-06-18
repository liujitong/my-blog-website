package xyz.mlxkj.myblog_server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.mlxkj.myblog_server.common.result;
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
@Repository
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    @Select("select * from users where username = #{username} and pwd = #{pwd}")
    Users searchByUsernameaAndPwd(@Param("username") String username,@Param("pwd") String pwd);

    @Select("select * from users where username = #{username}")
    Users searchByUsername(String username);
}
