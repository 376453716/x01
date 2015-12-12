package com.xh.util.encrypt;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by xionghao on 25/11/2015.
 */
public class EnscypDES {

    private KeyGenerator keyGenerator;
    //??
    private SecretKey secretKey;
    //?????????
    private Cipher cipher;

    private byte[] cipherByte;

    public EnscypDES(String encryptType) {
        try {
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            keyGenerator = KeyGenerator.getInstance(encryptType);
            secretKey = keyGenerator.generateKey();
            cipher = Cipher.getInstance(encryptType);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public String encode(String src) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            cipherByte = cipher.doFinal(src.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return new String(cipherByte);
    }

    public String decode(String src) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            cipherByte = cipher.doFinal(src.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return new String(cipherByte);
    }
}
