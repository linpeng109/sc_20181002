package com.cn.jpa.dao;

import com.cn.jpa.entity.AuthorityBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityBaseDao extends JpaRepository<AuthorityBase, String> {
    public AuthorityBase save(AuthorityBase authorityBase);

    public void deleteByAuthorityBaseName(String AuthorityBaseName);
}
