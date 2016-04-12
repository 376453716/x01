package com.xh.rabbit.web;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xh on 30/01/16.
 */
public class CompanyProcessor implements PageProcessor {

    private final static String COMPANY_LIST_URL = "http://cd\\.to8to\\.com/company/list_\\d+\\.html";
    private final static String COMPANY_HOME_URL = "http://cd\\.to8to\\.com/zs/\\d{7}/$";
    private final static String COMPANY_DESCRIBE_URL = "http://cd\\.to8to\\.com/zs/company\\d{7}/";
    private final static String COMPANY_CONNECT_URL = "http://cd\\.to8to\\.com/zs/\\d+/company-connect-1\\.html";

    // http://cd.to8to.com/zs/1263077/company-connect-1.html http://cd.to8to.com/zs/company1263077/

    private final List<String> companyIdList = new ArrayList<>();
    private final List<Map<String, String>> companyDescribes = new ArrayList<>();

    private final static Logger log = LoggerFactory.getLogger(CompanyProcessor.class);

    private final static String CONPANY_CLASS_NAME = "zgscl_name";

    private Site site = Site.me().setRetryTimes(1).setSleepTime(100);

    public List<String> getCompanyIds() {
        return companyIdList;
    }

    public void process(Page page) {
        if (page.getUrl().regex(COMPANY_LIST_URL).match()) {
            //页面进
            Html html = page.getHtml();
            //模型出
            //List<String> companyUrl = html.css("a.zgscl_name", "href").regex("\\d{7}").all();
            //log.info(companyUrl + "---" + companyUrl);
            //companyIdList.addAll(companyUrl);
            //请求出
            //http://cd.to8to.com/company/list_2.html
            //page.addTargetRequests(page.getHtml().links().regex("(http://cd\\.to8to\\.com/company/list_\\d+\\.html)").all());

            //company home page
            //http://cd.to8to.com/zs/3284108/
            //page.addTargetRequests(page.getHtml().links().regex(COMPANY_HOME_URL).all());
            page.addTargetRequest(page.getHtml().links().regex(COMPANY_HOME_URL).toString());
        } else if (page.getUrl().regex(COMPANY_HOME_URL).match()) {
            //page.addTargetRequests(page.getHtml().links().regex(COMPANY_DESCRIBE_URL).all());
            page.addTargetRequest(page.getHtml().links().regex(COMPANY_DESCRIBE_URL).toString());
        } else if (page.getUrl().regex(COMPANY_DESCRIBE_URL).match()) {
            Html html = page.getHtml();
            //模型出
            Map<String, String> companyDescribeMap = new HashMap<>();
            String companyName = html.xpath("//div[@class='zd_name']/h1/text()").toString();
            String companyDescribeKey = html.css("p.sign_title", "text").toString();
            String companyDescribeValue = html.xpath("//div[@class='describe']/p/text()").toString();
            companyDescribeMap.put(companyDescribeKey, companyDescribeValue);
            List<String> keyList = html.css("td.thead", "text").all();
            List<String> valueList = html.css("td.content", "text").all();
            for (int i = 0; i < keyList.size() && i < valueList.size(); i++) {
                companyDescribeMap.put(keyList.get(i), valueList.get(i));
            }
            page.putField("companyName", companyName);
            page.putField("detail", companyDescribeMap);
            log.info(companyName);
            page.addTargetRequest(page.getHtml().links().regex(COMPANY_CONNECT_URL).toString());
        } else if (page.getUrl().regex(COMPANY_CONNECT_URL).match()) {
            Html html = page.getHtml();
            List<String> detailList = html.xpath("//div[@class='detail']/dl/dd/text()").all();
            List<String> detailList2 = html.xpath("//div[@class='detail']/p/text()").all();
            log.info(detailList.toString());
            log.info(detailList2.toString());
            page.putField("connectDetail", detailList);
        }
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        CompanyProcessor companyProcessor = new CompanyProcessor();
        Spider.create(companyProcessor).
                addUrl("http://cd.to8to.com/company/list_1.html").
                addPipeline(new MyJsonFIlePipeLine("/Users/xh/IdeaProjects/x01/src/main/java/com/xh/rabbit/web")).
                thread(1).run();
    }
}
