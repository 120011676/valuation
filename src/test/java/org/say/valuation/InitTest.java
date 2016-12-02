package org.say.valuation;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by say on 02/12/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitTest {
    @Resource
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(InitTest.class);

    @Test
    @Ignore
    public void init() {
        User user = new User();
        user.setName("admin");
        user.setUsername("admin");
        user.setPassword("$shiro1$SHA-256$500000$sDjtFUcnr7tnptj/Esorkw==$hgDNf/NjAtzSLOSMmHlbIcB7t7B9O2LYjl9nEafz0mk=");
        user.setStatus(true);
        User user1 = this.userService.save(user);
        LOGGER.info(user1.toString());
    }
}
