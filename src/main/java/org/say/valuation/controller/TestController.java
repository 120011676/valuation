package org.say.valuation.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by say on 17/11/2016.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("a")
    public List<User> a() {
        User user = new User();
        user.setName("aaa中文");
        System.out.println(user.getId());
        this.userService.save(user);
        List<User> users = this.userService.list();
        System.out.println(users);
        System.out.println("aaa");
        return users;
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
}
