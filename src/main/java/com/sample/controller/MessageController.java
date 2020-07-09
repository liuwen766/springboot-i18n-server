package com.sample.controller;

import com.sample.utils.MessageSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 测试Controller
 *
 * @author liuwen
 * @date 2020-07-08
 */
@RestController
@RequestMapping("/")
public class MessageController {
    //自定义国际化
    @Autowired
    private MessageSourceUtil messageSourceUtil;

    //springboot内置国际化
    @Autowired
    private MessageSource messageSource;

    /**
     * 测试使用{@link MessageSource}
     *
     * @return {@link ResponseEntity}
     */
    @RequestMapping("/message")
    public ResponseEntity pingResource(){
        Map<String ,String> result = new HashMap<>(3);

        result.put("default",messageSource.getMessage("hello", null, "", null));
        result.put("en_US",messageSource.getMessage("hello", null, "", Locale.US));
        result.put("zh_CN",messageSource.getMessage("hello", null, "", Locale.SIMPLIFIED_CHINESE));

        return ResponseEntity.ok(result);
    }


    /**
     * 测试使用{@link MessageSourceUtil}
     *
     * @return {@link ResponseEntity}
     */
    @RequestMapping("/util")
    public ResponseEntity pingUtil(){
        return ResponseEntity.ok(messageSourceUtil.getMessage("hello"));
    }
}
