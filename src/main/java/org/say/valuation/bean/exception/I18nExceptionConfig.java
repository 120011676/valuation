package org.say.valuation.bean.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by say on 19/12/2016.
 */
@Configuration
public class I18nExceptionConfig {

    @Resource
    private MessageSource messageSource;

    @Bean
    public I18nMsgException i18nMsgException() {
        I18nMsgException i18nMsgException = new I18nMsgException();
        I18nMsgException.setMessageSource(this.messageSource);
        return i18nMsgException;
    }
}
