package com.cn.web;

import com.cn.jpa.dao.AuthorityBaseService;
import com.cn.jpa.dao.UserBaseService;
import com.cn.jpa.entity.AuthorityBase;
import com.cn.jpa.entity.UserBase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/userbase")
@Log4j2
public class UserBaseController {
    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private AuthorityBaseService authorityBaseService;

    @RequestMapping("/findAll")
    public List<UserBase> findAll() {
        return userBaseService.findAll();
    }

    @RequestMapping("/findAll/{page}/{size}")
    public Page<UserBase> findAll(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserBase> pageList = userBaseService.findAll(pageable);
        return pageList;
    }

    @RequestMapping("/count")
    public long count() {
        return userBaseService.count();
    }

    @RequestMapping("/countAllBySexAndAgeLessThanEqual/{sex}/{age}")
    public long countAllBySexAndAgeLessThanEqual(@PathVariable("sex") boolean sex, @PathVariable("age") int age) {
        return userBaseService.countAllBySexAndAgeLessThanEqual(sex, age);
    }

    @RequestMapping("/findBySexAndAgeGreaterThanEqual/{sex}/{age}")
    public List<UserBase> findBySexAndAgeGreaterThanEqual(@PathVariable("sex") boolean sex, @PathVariable("age") int age) {
        return userBaseService.findBySexAndAgeGreaterThanEqual(sex, age);
    }

    @RequestMapping("/findByUsernameLike/{page}/{size}/{usernameLike}")
    public Page<UserBase> findByUsernameLike(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("usernameLike") String usernameLike) {
        Pageable pageable = PageRequest.of(page, size);
        log.debug("username like " + usernameLike);
        return userBaseService.findByUsernameLike(pageable, "%" + usernameLike + "%");
    }

    @RequestMapping("/deleteAllByAgeIsLessThanEqual/{age}")
    public List<UserBase> deleteAllByAgeIsLessThanEqual(@PathVariable("age") int age) {
        return userBaseService.deleteByAgeIsLessThanEqual(age);
    }

    @RequestMapping("/init/{number}")
    public String init(@PathVariable("number") int number) {
        for (int i = 0; i < number; ++i) {
            String randomString = UUID.randomUUID().toString().substring(0, 7);
            UserBase userBase = new UserBase();
            userBase.username = randomString;
            userBase.password = randomString;
            Random random = new Random();
            userBase.sex = random.nextBoolean();
            userBase.age = 20 + random.nextInt(40);
            List<AuthorityBase> list = authorityBaseService.findAll();
            userBase.authorityBaseList = list;
            UserBase result = userBaseService.save(userBase);
            log.debug(result);
        }
        return "success";
    }

}
