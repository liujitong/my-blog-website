package xyz.mlxkj.myblog_server.service.impl;

import xyz.mlxkj.myblog_server.entity.Users;
import xyz.mlxkj.myblog_server.mapper.UsersMapper;
import xyz.mlxkj.myblog_server.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者：刘纪彤
 * @since 2024-06-15
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
