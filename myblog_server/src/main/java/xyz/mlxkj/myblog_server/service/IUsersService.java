package xyz.mlxkj.myblog_server.service;


import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.model.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
public interface IUsersService extends IService<Users> {
    public result login(String username, String pwd);

    result register(String username, String password);

    result changePwd(String username, String password);
}
