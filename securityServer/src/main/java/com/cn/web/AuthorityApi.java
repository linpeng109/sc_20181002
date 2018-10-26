package com.cn.web;

import com.cn.jpa.dao.AuthorityDao;
import com.cn.jpa.entity.Authority;
import com.cn.jpa.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/authority")
public class AuthorityApi {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/findall")
    public List<Authority> findall() {
        return authorityService.findAll();
    }

    @RequestMapping("/init")
    public String initAuthority(int num) {
        Authority admin = new Authority();
        admin.authority = "ROLE_ADMIN";
        authorityService.save(admin);

        Authority guest = new Authority();
        admin.authority = "ROLE_GUEST";
        authorityService.save(guest);

        Authority user = new Authority();
        admin.authority = "ROLE_USER";
        authorityService.save(user);

        return "success";
    }

}
