package tmall.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordUtil {
    /**
     * 密码不可逆加密，取 md5截取 [8,24)再算md5
     * @param password 未加密的原始密码
     * @return 加密后的密码
     */
    public static String encryptPassword(String password){
        return md5Encrypt(md5Encrypt(password).substring(8,24));
    }
    private static String md5Encrypt(String str){
        String result = "";
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            result =  new BigInteger(1, md.digest()).toString(16);
        } catch (Exception ignored) {
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(encryptPassword("xi753951"));
    }
}
