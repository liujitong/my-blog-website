package xyz.mlxkj.myblog_server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.model.Users;
import xyz.mlxkj.myblog_server.dao.UsersMapper;
import xyz.mlxkj.myblog_server.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public result login(String username, String pwd) {
        Users user = usersMapper.searchByUsernameaAndPwd(username, pwd);
        if (user == null) {
            return result.fail("用户名或密码错误");
        }
        return result.succ(user);
    }
}
