package org.say.valuation.bean.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by say on 07/12/2016.
 */
@Configuration
public class ActivitiConfig {

    @Bean
    public CommandLineRunner init(RepositoryService repositoryService, RuntimeService runtimeService, TaskService taskService) {
        return strings -> {
            System.out.println("Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
            System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
            runtimeService.startProcessInstanceByKey("oneTaskProcess");
            System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
        };
    }


    @Bean
    public DataSource database() {
        return DataSourceBuilder.create()
                .url(" jdbc:mysql://127.0.0.1:3306/valuation?useSSL=true&createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&k&autoReconnect=true&autoReconnectForPools=true&failOverReadOnly=false")
                .username("root")
                .password("root")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

}
