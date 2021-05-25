package cn.zjutleo.health_server.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 加密解密工具类
 */
public class EncryptUtil {
    /**
     * SHA256散列
     *
     * @param sourceStr 目标字符串
     * @return 散列结果
     */
    public static String getSha256(String sourceStr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
        messageDigest.update(sourceStr.getBytes(StandardCharsets.UTF_8));
        return Hex.encodeHexString(messageDigest.digest());
    }

    /**
     * 二进制数据转base64
     *
     * @param binaryData 二进制数据
     * @return base64字符串
     */
    public static String toBase64String(byte[] binaryData) {
        return new String(Base64.encodeBase64(binaryData));
    }
}
