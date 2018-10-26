package com.cn.web;

import com.cn.jpa.service.AuthorityBaseService;
import com.cn.jpa.entity.AuthorityBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/authoritybase")
@ApiIgnore
public class AuthorityBaseController {
    @Autowired
    private AuthorityBaseService authorityBaseService;

    @RequestMapping("/init")
    public String init() {
        AuthorityBase admin = new AuthorityBase();
        admin.authorityBaseName = "ROLE_ADMIN";
        authorityBaseService.save(admin);
        AuthorityBase comm = new AuthorityBase();
        comm.authorityBaseName = "ROLE_COMM";
        authorityBaseService.save(comm);
        AuthorityBase user = new AuthorityBase();
        user.authorityBaseName = "ROLE_USER";
        authorityBaseService.save(user);

        return "success";
    }
}
