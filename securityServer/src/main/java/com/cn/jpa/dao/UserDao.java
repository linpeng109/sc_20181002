package com.cn.jpa.dao;

import com.cn.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, String> {
    public User findByUsername(String username);

    public List<User> findAll();

    public User save(User user);

    public void delete(User user);
}
