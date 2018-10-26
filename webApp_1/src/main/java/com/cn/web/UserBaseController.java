package com.cn.web;

import com.cn.jpa.service.AuthorityBaseService;
import com.cn.jpa.service.UserBaseService;
import com.cn.jpa.entity.AuthorityBase;
import com.cn.jpa.entity.UserBase;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

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

    @ApiOperation(value = "查询所有用户", notes = "不分页查询所有用户")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<UserBase> findAll() {
        return userBaseService.findAll();
    }

    @ApiOperation(value = "查询所有用户", notes = "分页查询所有用户，格式：/findAll/{page}/{size}")
    @RequestMapping(value = "/findAll/{page}/{size}", method = RequestMethod.GET)
    public Page<UserBase> findAll(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserBase> pageList = userBaseService.findAll(pageable);
        return pageList;
    }

    @ApiOperation(value = "查询所有用户数量", notes = "无条件不分页查询所有用户数量")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long count() {
        return userBaseService.count();
    }

    @ApiOperation(value = "依据条件查询所有用户数量", notes = "依据条件：性别，年龄，查询所有用户数量")
    @RequestMapping(value = "/countAllBySexAndAgeLessThanEqual/{sex}/{age}", method = RequestMethod.GET)
    public long countAllBySexAndAgeLessThanEqual(@PathVariable("sex") boolean sex, @PathVariable("age") int age) {
        return userBaseService.countAllBySexAndAgeLessThanEqual(sex, age);
    }

    @ApiOperation(value = "依条件查询用户", notes = "依据条件：性别，年龄，不分页查询所有符合条件的用户")
    @RequestMapping(value = "/findBySexAndAgeGreaterThanEqual/{sex}/{age}", method = RequestMethod.GET)
    public List<UserBase> findBySexAndAgeGreaterThanEqual(@PathVariable("sex") boolean sex, @PathVariable("age") int age) {
        return userBaseService.findBySexAndAgeGreaterThanEqual(sex, age);
    }

    @ApiOperation(value = "依据用户名模糊查询用户", notes = "模糊条件分页查询所有用户，其中sernameLike为模糊条件")
    @RequestMapping(value = "/findByUsernameLike/{page}/{size}/{usernameLike}", method = RequestMethod.GET)
    public Page<UserBase> findByUsernameLike(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("usernameLike") String usernameLike) {
        Pageable pageable = PageRequest.of(page, size);
        log.debug("username like " + usernameLike);
        return userBaseService.findByUsernameLike(pageable, "%" + usernameLike + "%");
    }

    @ApiOperation(value = "依据条件：年龄小于等于age，删除所有用符合条件的用户", notes = "依据条件：年龄小于等于age，删除所有用符合条件的用户")
    @RequestMapping(value = "/deleteAllByAgeIsLessThanEqual/{age}", method = RequestMethod.DELETE)
    public List<UserBase> deleteAllByAgeIsLessThanEqual(@PathVariable("age") int age) {
        return userBaseService.deleteByAgeIsLessThanEqual(age);
    }

    @ApiIgnore
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
