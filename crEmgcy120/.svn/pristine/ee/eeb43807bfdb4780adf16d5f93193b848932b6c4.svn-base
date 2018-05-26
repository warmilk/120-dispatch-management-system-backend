package com.emgcy120.core.common.util;

import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.shiro.ShiroConfiguration;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 生成token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 14:41
 */
public class TokenGenerator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new CustomException( ErrorCode.USER_ACCESS_TOKEN_GENERATE_ERROR ) ;
        }
    }
    
    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword,String salt) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] saltByte = salt.getBytes();
        byte[] hashPassword = Digests.sha1(plain.getBytes(), saltByte, ShiroConfiguration.HASH_INTERATIONS);
        return Encodes.encodeHex(hashPassword);
    }
    
    public static void main(String[] args) {
		System.out.println(entryptPassword("123456","123456"));
	}
}
