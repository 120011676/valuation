package org.say.valuation.bean.shiro;

import lombok.Setter;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by say on 29/11/2016.
 */
@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfiguration {

    @Resource
    private DataSource dataSource;

    @Setter
    private String filterChainDefinitions;
    @Setter
    private String unauthorizedUrl;
    @Setter
    private String successUrl;
    @Setter
    private String loginUrl;

    @Setter
    private String authenticationQuery;
    @Setter
    private String userRolesQuery;
    @Setter
    private String permissionsQuery;

    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean sffb = new ShiroFilterFactoryBean();
        return sffb;
    }

    @Bean
    public JdbcRealm jdbcRealm() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setAuthenticationQuery("");
        jdbcRealm.setUserRolesQuery("");
        jdbcRealm.setPermissionsQuery("");
        System.out.println("dataSource:" + this.dataSource);
        jdbcRealm.setDataSource(this.dataSource);
        return jdbcRealm;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean sffb = new ShiroFilterFactoryBean();
        sffb.setLoginUrl(this.loginUrl);
        sffb.setSuccessUrl(this.successUrl);
        sffb.setUnauthorizedUrl(this.unauthorizedUrl);
        sffb.setFilterChainDefinitions(this.filterChainDefinitions);
        return sffb;
    }
}
