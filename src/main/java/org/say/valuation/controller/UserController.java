package org.say.valuation.controller;

import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.say.valuation.util.ControllerUtil;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by say on 02/12/2016.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("find")
    public Page<User> find(User user) {
        return this.userService.find(ControllerUtil.getPageNum(), ControllerUtil.getPageSize(), user);
    }
}
