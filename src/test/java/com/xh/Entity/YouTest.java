package com.xh.Entity;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xh on 08/09/15.
 */
public class YouTest {

    //private static String URL_PRIFIX = "http://www.youku.com/v_olist/c_97_g__a__sg__mt__lg__q__s_1_r_0_u_0_pt_0_av_0_ag_0_sg__pr__h__d_1_p_";
    private static String URL_PRIFIX = "http://www.youku.com/v_olist/c_97_g_%E8%A8%80%E6%83%85_a_%E5%A4%A7%E9%99%86_sg__mt__lg__q__s_1_r_0_u_1_pt_1_av_0_ag_0_sg__pr__h__d_1_p_";
    //private static String MOVIEURL_PRIFIX = "http://www.youku.com/v_olist/c_96_g__a__sg__mt__lg__q__s_1_r_0_u_1_pt_1_av_0_ag_0_sg__pr__h__d_1_p_";
    private static String MOVIEURL_PRIFIX = "http://www.youku.com/v_olist/c_96_g__a_大陆_sg__mt__lg__q__s_1_r_0_u_1_pt_1_av_0_ag_0_sg__pr__h__d_1_p_";

    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 30; i++) {
            getPageContent(URL_PRIFIX + i + ".html");
        }
    }

    private static void getPageContent(String pageUrl) throws IOException {
        BufferedReader reader = getHttpEntity(pageUrl);
        String line = "";
        while ((line = reader.readLine()) != null) {
            if (line.indexOf("<div class=\"p-meta-title\"><a href=\"") > 0) {
                //MOVIE URL
                line = line.substring(line.indexOf("http:"), line.indexOf(".html"));
                String singleUrl = line + ".html";
                BufferedReader readerTmp = getHttpEntity(singleUrl);
                while ((line = readerTmp.readLine()) != null) {
                    parseContentMovie(line);
                    //parseContent(line);
                    /*boolean matchFlag = false;
                    if (line.indexOf("吻") > 0) {
                        matchFlag = true;
                    }
                    if (matchFlag) {
                        System.out.println(singleUrl);
                        System.out.println("");
                        break;
                    }*/
                }
            }
        }
    }


    private static void parseContent(String line) throws IOException {


    }

    private static void parseContentMovie(String line) throws IOException {
        if (line.indexOf("id:'") > 0 && line.trim().length() == 27) {
            String id = line.substring(line.indexOf("'") + 1, line.lastIndexOf("'"));
            String urlTmp = "http://www.youku.com/show_point_id_" + id + ".html?dt=json&tab_num=4&__rt=1&__ro=reload_point";
            BufferedReader readerTmpContent = getHttpEntity(urlTmp);
            boolean matchFlag = false;
            while ((line = readerTmpContent.readLine()) != null) {
                if (line.indexOf("吻") > 0) {
                    matchFlag = true;
                    break;
                }
            }
            if (matchFlag) {
                System.out.println(urlTmp);
                System.out.println("");
            }
        }
    }

    private static BufferedReader getHttpEntity(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = null;
        try {
            response1 = httpclient.execute(httpGet);
            HttpEntity entity1 = response1.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity1.getContent()));
            return reader;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }
}
