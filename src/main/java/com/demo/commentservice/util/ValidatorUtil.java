package com.demo.commentservice.util;

import org.springframework.util.StringUtils;

public class ValidatorUtil {
    public static void validateIfEmpty(String value){
        if(StringUtils.isEmpty(value)){
            //throw new InvalidDataFormat("Value cannot be empty.");
        }
    }
}
