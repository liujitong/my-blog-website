package xyz.mlxkj.myblog_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.dao.UsersMapper;
import xyz.mlxkj.myblog_server.model.Users;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("{uid}")
    public result getUserById(@PathVariable("uid") Integer uid) {
        return result.succ(usersMapper.selectById(uid));
    }
    @RequestMapping("/edit")
    public result editUser(@RequestBody Users user) {
        System.out.println("user:"+user);
        usersMapper.updateById(user);
        return result.succ("修改成功");
    }

}
