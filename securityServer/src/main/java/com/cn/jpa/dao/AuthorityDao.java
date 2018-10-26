package com.cn.jpa.dao;

import com.cn.jpa.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityDao extends JpaRepository<Authority, String> {
    public List<Authority> findAll();

    public Authority save(Authority authority);

    public void delete(Authority authority);
}
