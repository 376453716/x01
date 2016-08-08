package com.xh.util.decrypt;


import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;

public class SignUtils {

    private static final Logger logger = Logger.getLogger(SignUtils.class);


    /**
     * @param params        参数
     * @param secretkey     商户密钥
     * @param encodeCharset 编码
     * @return
     */
    //先对need_sign做升序排序,然后对报文做签名,签名规则 md5(quote_plus(need_sign + secretkey))
    public static String doSign4Schools(Map<String, String> params, String secretkey, String encodeCharset) {
        Iterator<Entry<String, String>> it = params.entrySet().iterator();
        List<String> toSortList = new ArrayList<String>();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();

            toSortList.add(key + "=" + value);
        }
        Collections.sort(toSortList);
        StringBuilder signSB = new StringBuilder("");
        String needSign = "";

        for (String s : toSortList) {
            signSB.append(s);
        }
        needSign = signSB.toString();

        String data = new StringBuilder().append(needSign).append(secretkey).toString();
        String retData = "";
        try {
            retData = URLEncoder.encode(data, encodeCharset == null ? "utf-8" : encodeCharset);
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
        return md5(retData);
    }

    //$Http_method$URL$Param$secretKey
    public static String doSignApp4Server(Map<String, String> params, String secretkey, String url, String method, String encodeCharset) {
        Iterator<Entry<String, String>> it = params.entrySet().iterator();
        List<String> toSortList = new ArrayList<String>();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();

            toSortList.add(key + "=" + value);
        }
        Collections.sort(toSortList);
        StringBuilder signSB = new StringBuilder("");
        String needSign = "";

        for (String s : toSortList) {
            signSB.append(s);
        }
        needSign = signSB.toString();

        String data = new StringBuilder().append(method).append(url).append(needSign).append(secretkey).toString();
        String retData = "";
        try {
            retData = URLEncoder.encode(data, encodeCharset == null ? "utf-8" : encodeCharset);
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
        return md5(retData);
    }

    public static String md5(String inbuf) {
        try {
            MessageDigest dg = MessageDigest.getInstance("MD5");
            byte[] result = dg.digest(inbuf.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte bit : result) {
                sb.append(String.format("%02x", bit));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String md5(byte[] inbuf) {
        try {
            MessageDigest dg = MessageDigest.getInstance("MD5");
            byte[] result = dg.digest(inbuf);
            StringBuilder sb = new StringBuilder();
            for (byte bit : result) {
                sb.append(String.format("%02x", bit));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("username", "zhangsan");
//        map.put("password", "123456");
//        String sign = doSign4Schools(map, "qwertyuiopasdfghjklzxcvbnm", "utf-8");
//        System.out.println(sign);

        String str = "Amount=22.22Name=XXOrderNo=20151125101010SSSS2222SSSS";
        str = URLEncoder.encode(str);
        System.out.println(md5(str));
    }
}
