package com.atguigu.springboot06.user.controller;


import com.atguigu.springboot06.user.beans.User;
import com.atguigu.springboot06.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Dn
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/{id}")
//    @Cacheable(cacheNames = {"user"},cacheManager = "userCacheManager" )
    public User getUser(@PathVariable Long id){
        User user = userService.getById(id);
        return user;
    }

}
