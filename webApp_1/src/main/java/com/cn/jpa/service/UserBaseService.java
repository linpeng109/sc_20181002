package com.cn.jpa.service;

import com.cn.jpa.dao.UserBaseDao;
import com.cn.jpa.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Page<UserBase> findAll(Pageable pageable) {
        return userBaseDao.findAll(pageable);
    }

    public List<UserBase> findBySexAndAgeGreaterThanEqual(boolean sex, int age) {
        return userBaseDao.findBySexAndAgeGreaterThanEqual(sex, age);
    }

    public Page<UserBase> findByUsernameLike(Pageable pageable, String usernameLike) {
        return userBaseDao.findByUsernameLike(pageable, usernameLike);
    }

    @Transactional
    public List<UserBase> deleteByAgeIsLessThanEqual(int age) {
        return userBaseDao.deleteByAgeIsLessThanEqual(age);
    }

    public long count() {
        return userBaseDao.count();
    }

    public long countAllBySexAndAgeLessThanEqual(boolean sex, int age) {
        return userBaseDao.countAllBySexAndAgeLessThanEqual(sex, age);
    }

}
