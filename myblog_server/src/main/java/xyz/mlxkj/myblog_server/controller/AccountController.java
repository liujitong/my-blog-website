package xyz.mlxkj.myblog_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xyz.mlxkj.myblog_server.common.LoginMsg;
import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.dao.UsersMapper;
import xyz.mlxkj.myblog_server.model.Users;
import xyz.mlxkj.myblog_server.service.IUsersService;
import xyz.mlxkj.myblog_server.service.impl.UsersServiceImpl;


import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    private UsersServiceImpl usi;
    @PostMapping("/login")
    public result login(@Validated @RequestBody LoginMsg lms){
        return usi.login(lms.getUsername(),lms.getPassword());
    }

}
