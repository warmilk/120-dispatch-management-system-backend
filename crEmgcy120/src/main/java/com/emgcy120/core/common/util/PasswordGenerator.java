package com.emgcy120.core.common.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by weijieliao on 2017/12/18.
 */
public class PasswordGenerator {

    public static String getRandomPassword(){

        int bit = 8 ;
        // 因为o和0,l和1很难区分,所以,去掉大小写的o和l和数字0、1
        String str = "23456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";// 初始化种子
        return RandomStringUtils.random(bit, str);

    }

}
