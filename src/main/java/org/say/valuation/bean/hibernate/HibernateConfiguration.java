package org.say.valuation.bean.hibernate;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by say on 30/11/2016.
 */
//@Configuration
public class HibernateConfiguration extends WebMvcConfigurerAdapter {
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        OpenSessionInViewFilter osivf = new OpenSessionInViewFilter();
//        registrationBean.setFilter(osivf);
//        List<String> urlPatterns = new ArrayList<>();
//        urlPatterns.add("/*");
//        registrationBean.setUrlPatterns(urlPatterns);
//        registrationBean.addInitParameter("singleSession", "false");
//        return registrationBean;
//    }

//    @Interceptors(value = OpenSessionInViewInterceptor.class)
//    public OpenSessionInViewInterceptor a() {
//        OpenSessionInViewInterceptor osivi = new OpenSessionInViewInterceptor();
//        return osivi;
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addWebRequestInterceptor(new OpenSessionInViewInterceptor()).addPathPatterns("/**");
//    }
}
