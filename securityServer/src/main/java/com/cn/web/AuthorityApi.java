package com.cn.web;

import com.cn.jpa.dao.AuthorityDao;
import com.cn.jpa.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/authority")
public class AuthorityApi {

    @Autowired
    private AuthorityDao authorityDao;

    @RequestMapping("/findall")
    public List<Authority> findall() {
        return authorityDao.findAll();
    }

    @RequestMapping("/initauthority")
    public String initAuthority(int num) {
        Authority admin = new Authority();
        admin.authority = "ROLE_ADMIN";
        authorityDao.save(admin);

        Authority guest = new Authority();
        admin.authority = "ROLE_GUEST";
        authorityDao.save(guest);

        Authority user = new Authority();
        admin.authority = "ROLE_USER";
        authorityDao.save(user);

        return "success";
    }

}
