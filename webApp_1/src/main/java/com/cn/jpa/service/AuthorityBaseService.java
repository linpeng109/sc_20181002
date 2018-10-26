package com.cn.jpa.service;

import com.cn.jpa.dao.AuthorityBaseDao;
import com.cn.jpa.entity.AuthorityBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityBaseService {
    @Autowired
    private AuthorityBaseDao authorityBaseDao;

    public List<AuthorityBase> findAll() {
        return authorityBaseDao.findAll();
    }

    public AuthorityBase save(AuthorityBase authorityBase) {
        return authorityBaseDao.save(authorityBase);
    }
}
