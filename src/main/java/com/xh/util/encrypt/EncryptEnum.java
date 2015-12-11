package com.xh.util.encrypt;

/**
 * Created by xionghao on 25/11/2015.
 */
public enum EncryptEnum {
    DES("DES"), DES3("DESede"), AES("AES"), RSA("RSA"), DSA("DSA");
    private String encryptType;

    EncryptEnum(String encryptType) {
        this.encryptType = encryptType;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public static void main(String[] args) {
        String a = null;
        Object o = a;
        a = (String) o;
        System.out.println(a);
    }
}
