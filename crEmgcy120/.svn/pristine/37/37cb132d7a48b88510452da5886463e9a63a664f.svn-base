package com.emgcy120.core.common.util;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	static MessageDigest MD5 = null;

	static {
		try {
			MD5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ne) {
			ne.printStackTrace();
		}
	}
	
	/**
	 * 对一个文件获取md5值
	 * @author chenshuzhuo
	 * @return md5串
	 */
	public static String getMD5(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[8192];
			int length;
			while ((length = fileInputStream.read(buffer)) != -1) {
				MD5.update(buffer, 0, length);
			}
			return new String(Hex.encodeHex(MD5.digest()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (fileInputStream != null)
					fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
    public static String encode(String string) {
        String encode = defaultEncode(string);
        StringBuilder sb = new StringBuilder();
        sb.append("cr-emgcy");
        int i = 0;

        for(int length = encode.length() / 2; i < length; ++i) {
            sb.append(encode.charAt(i * 2 + 1));
            sb.append(encode.charAt(i * 2));
        }

        sb.append("@.com");
        return defaultEncode(sb.toString());
    }

    public static String defaultEncode(String string) {
        StringBuilder sb = new StringBuilder(32);

            byte[] hashValue = MD5.digest(string.getBytes());

            for(int i = 0; i < hashValue.length; ++i) {
                sb.append(Integer.toHexString((hashValue[i] & 240) >> 4));
                sb.append(Integer.toHexString(hashValue[i] & 15));
            }

        return sb.toString();
    }
}
