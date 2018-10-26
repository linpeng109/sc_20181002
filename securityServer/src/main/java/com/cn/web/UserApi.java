package com.cn.web;

import com.cn.jpa.entity.Authority;
import com.cn.jpa.entity.User;
import com.cn.jpa.service.AuthorityService;
import com.cn.jpa.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/findall")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findbyusername/{username}")
    public User findByUsername(@PathVariable(name = "username") String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping("/init/{num}")
    public String init(@PathVariable(name = "num") int num) {
        List<Authority> userAuthoritys = authorityService.findAll();
        for (int i = 0; i < num; ++i) {
            UUID uuid = UUID.randomUUID();
            User user = new User();
            user.username = uuid.toString().substring(23, 31);
            user.password = uuid.toString().substring(23, 31);
            user.setAuthorities(userAuthoritys);
            User result = userService.save(user);
            log.debug(result);
        }
        return "success";
    }
}
