package org.say.valuation.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by say on 17/11/2016.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("a")
    public Page<User> a() {
        User user = new User();
        user.setUsername(new Random().nextInt(100000) + "");
        user.setName("aaa中文");
        User u = this.userService.save(user);
        System.out.println(u);
        System.out.println(user.getId());
        Page<User> users = this.userService.find(0, 1000, null);
        System.out.println(users.getContent());
        System.out.println("aaa");
        return users;
    }


    @RequestMapping("lz")
    public User lz() {
        User user = this.userService.findByUsername("admin");
        System.out.println(user);
        return null;
    }

    @RequestMapping("b")
    public User b() {
        return null;
    }

    @RequestMapping("c")
    public void c() {
        int c = 1 / 0;
    }


    @RequestMapping("jsonp")
    public User jsonp() {
        User user = new User();
        user.setName("jsonp中文");
//        throw new NullPointerException();
        return user;
    }

    @RequestMapping("ex")
    public User ex() {
        System.out.println("11");
        throw new NullPointerException();
    }

    @RequestMapping("ex1")
    @RequiresPermissions("ss")
    public User ex1() {
        System.out.println("11");
        throw new NullPointerException("666" + ((char) 27) + "异常错误");
    }


    @RequestMapping("user")
    public User user() {
        User user = new User();
        user.setName("jsonp中文111");
//        throw new NullPointerException();
        return user;
    }
}
