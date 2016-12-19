package org.say.valuation.bean.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * Created by say on 19/12/2016.
 */
public class I18nMsgException extends MsgException {

    private static MessageSource MESSAGE_SOURCE;

    I18nMsgException() {
        super(null, null);
    }

    public I18nMsgException(String code) {
        this(code, (String[]) null);
    }

    public I18nMsgException(String code, Locale locale) {
        this(code, null, locale);
    }

    public I18nMsgException(String code, String[] args) {
        this(code, args, null);
    }


    public I18nMsgException(String code, String[] args, Locale locale) {
        super(code, MESSAGE_SOURCE.getMessage(code, args, locale != null ? locale : (LocaleContextHolder.getLocale() != null ? LocaleContextHolder.getLocale() : Locale.getDefault())));
//        super(code, MESSAGE_SOURCE.getMessage(code, args, locale != null ? locale : (ControllerUtil.getRequest() != null ? RequestContextUtils.getLocale(ControllerUtil.getRequest()) : Locale.getDefault())));
//        super(code, MESSAGE_SOURCE.getMessage(code, args, locale != null ? locale : (ControllerUtil.getRequest() != null && ControllerUtil.getRequest().getLocale() != null ? ControllerUtil.getRequest().getLocale() : Locale.getDefault())));
//        super(code, MESSAGE_SOURCE.getMessage(code, args, null));
//        System.out.println(MESSAGE_SOURCE.getMessage(code, args,"momo", null));
    }

    static void setMessageSource(MessageSource messageSource) {
        MESSAGE_SOURCE = messageSource;
    }
}
