package org.say.valuation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan(basePackages="org.say.valuation")
//@EntityScan(basePackages="org.say.valuation.entity")
//@EnableJpaRepositories(basePackages="org.say.valuation.dao")
//@EnableAutoConfiguration
//@EnableAdminServer


//@Configuration
@ComponentScan({"org.activiti", "org.say.valuation"})
@SpringBootApplication
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }


//    @Bean
//    public CommandLineRunner init(final ActivitiService myService) {
//        return new CommandLineRunner() {
//            public void run(String... strings) throws Exception {
//                if (personRepository.findAll().size() == 0) {
//                    personRepository.save(new Person("wtr"));
//                    personRepository.save(new Person("wyf"));
//                    personRepository.save(new Person("admin"));
//                }
//                if (compRepository.findAll().size() == 0) {
//                    Comp group = new Comp("great company");
//                    compRepository.save(group);
//                    Person admin = personRepository.findByPersonName("admin");
//                    Person wtr = personRepository.findByPersonName("wtr");
//                    admin.setComp(group); wtr.setComp(group);
//                    personRepository.save(admin); personRepository.save(wtr);
//                }
//            }
//        };
//    }
}