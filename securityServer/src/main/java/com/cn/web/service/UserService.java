package com.cn.web.service;

import com.cn.jpa.dao.UserDao;
import com.cn.jpa.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }
}
