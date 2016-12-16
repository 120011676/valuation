package org.say.valuation.bean.activiti;

import org.springframework.context.annotation.Configuration;

/**
 * Created by say on 07/12/2016.
 */
@Configuration
public class ActivitiConfig {

//    @Bean
//    public CommandLineRunner init(RepositoryService repositoryService, RuntimeService runtimeService, TaskService taskService) {
//        return strings -> {
//            System.out.println("Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
//            System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//            runtimeService.startProcessInstanceByKey("oneTaskProcess");
//            System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
//        };
//    }


//    @Bean
//    public CommandLineRunner init(RepositoryService repositoryService, RuntimeService runtimeService, TaskService taskService) {
//        return strings -> {
//            Map<String, Object> variables = new HashMap<String, Object>();
//            variables.put("applicantName", "John Doe");
//            variables.put("email", "john.doe@activiti.com");
//            variables.put("phoneNumber", "123456789");
//            runtimeService.startProcessInstanceByKey("hireProcess", variables);
//        };
//    }


//    @Bean
//    public InitializingBean usersAndGroupsInitializer(IdentityService identityService) {
//        return () -> {
//            Group group = identityService.newGroup("user");
//            group.setName("users");
//            group.setType("security-role");
//            identityService.saveGroup(group);
//            User admin = identityService.newUser("admin");
//            admin.setPassword("admin");
//            identityService.saveUser(admin);
//
//        };
//    }

//    @Bean
//    public DataSource database() {
//        return DataSourceBuilder.create()
//                .url(" jdbc:mysql://127.0.0.1:3306/valuation?useSSL=true&createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&k&autoReconnect=true&autoReconnectForPools=true&failOverReadOnly=false")
//                .username("root")
//                .password("root")
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .build();
//    }

//    @Bean
//    public StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration(){
//        StandaloneProcessEngineConfiguration spec = new StandaloneProcessEngineConfiguration();
//        spec.setDataSource()
//        return spec;
//    }
}
