package org.say.valuation.controller;

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
    public String a() {
        User user= new User();
        user.setName("aaa中文");
        System.out.println(user.getId());
        this.userService.save(user);
        List<User> users = this.userService.list();
        System.out.println(users);
        return "a";
    }
}
