package xyz.mlxkj.myblog_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xyz.mlxkj.myblog_server.common.AccountMsg;
import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.service.impl.UsersServiceImpl;

@RestController
public class AccountController {
    @Autowired
    private UsersServiceImpl usi;
    @PostMapping("/login")
    public result login(@Validated @RequestBody AccountMsg lms){
        return usi.login(lms.getUsername(),lms.getPassword());
    }
    @PostMapping("/register")
    public result register(@Validated @RequestBody AccountMsg lms) {
        return usi.register(lms.getUsername(), lms.getPassword());
    }

}
