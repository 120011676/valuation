package org.say.valuation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by say on 17/11/2016.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("a")
    public String a(){
        return "a";
    }
}
