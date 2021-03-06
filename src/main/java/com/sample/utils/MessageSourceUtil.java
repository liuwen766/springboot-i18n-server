package com.sample.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * MessageSource工具
 * 依赖{@link MessageSource}
 *
 * @author liuwen
 * @date 2020-07-08
 */
@Component
public class MessageSourceUtil {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }

    public String getMessage(String code, Object[] args, String defaultMsg) {
        //设定语言
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, defaultMsg, locale);
    }

}
