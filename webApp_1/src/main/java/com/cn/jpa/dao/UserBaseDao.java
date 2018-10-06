package com.cn.jpa.dao;

import com.cn.jpa.entity.UserBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserBaseDao extends PagingAndSortingRepository<UserBase, String> {

    public long count();

    public List<UserBase> findAll();

    public Page<UserBase> findAll(Pageable pageable);

    public List<UserBase> findBySexAndAgeGreaterThanEqual(boolean sex, int age);

    public Page<UserBase> findByUsernameLike(String usernameLike, Pageable pageable);

    public UserBase findByUsername(String username);

    public UserBase save(UserBase userBase);
}
