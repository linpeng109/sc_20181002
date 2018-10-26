package com.cn.jpa.service;

import com.cn.jpa.dao.AuthorityDao;
import com.cn.jpa.entity.Authority;

import java.util.List;

public class AuthorityService {
    private AuthorityDao authorityDao;

    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    public Authority save(Authority authority) {
        return authorityDao.save(authority);
    }

    public void delete(Authority authority) {
        authorityDao.delete(authority);
    }
}
