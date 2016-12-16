package org.say.valuation.bean.init;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Created by say on 16/12/2016.
 */
@Configuration
public class InitBean {

    @Bean
    public CommandLineRunner init(UserService userService) {
        return new CommandLineRunner() {
            public void run(String... args) throws Exception {
                long c = userService.count();
                if (c == 0) {
                    User user = new User();
                    user.setId(1);
                    user.setName("admin");
                    user.setUsername("admin");
                    user.setPassword(new DefaultPasswordService().encryptPassword("admin"));
                    user.setStatus(true);
                    user.setCreateDate(new Date());
                    userService.save(user);
                }
            }
        };

    }
}
