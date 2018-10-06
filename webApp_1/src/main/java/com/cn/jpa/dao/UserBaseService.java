package com.cn.jpa.dao;

import com.cn.jpa.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBaseService {
    @Autowired
    private UserBaseDao userBaseDao;

    public UserBase save(UserBase userBase) {
        return userBaseDao.save(userBase);
    }

    public List<UserBase> findAll() {
        return userBaseDao.findAll();
    }

    public List<UserBase> findBySexAndAgeGreaterThanEqual(boolean sex, int age) {
        return userBaseDao.findBySexAndAgeGreaterThanEqual(sex, age);
    }

    public long count() {
        return userBaseDao.count();
    }

    public Page<UserBase> findAll(Pageable pageable) {
        return userBaseDao.findAll(pageable);
    }
}
