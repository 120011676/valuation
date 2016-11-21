package org.say.valuation.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by say on 21/11/2016.
 */
@Configuration
@EnableScheduling
public class SingleTask {

    @Scheduled(cron = "0 0/2 * * * ?")
    public void poll() {

    }
}
