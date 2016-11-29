package org.say.valuation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by say on 29/11/2016.
 */
@RestController
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "";
    }
}
