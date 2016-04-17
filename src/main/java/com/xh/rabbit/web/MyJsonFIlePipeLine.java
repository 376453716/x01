/*
package com.xh.rabbit.web;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

*/
/**
 * Created by xh on 30/01/16.
 *//*

public class MyJsonFIlePipeLine extends JsonFilePipeline {


    public MyJsonFIlePipeLine(String path) {
        super.setPath(path);
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void process(ResultItems resultItems, Task task) {
        String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;
        try {
            if (!resultItems.getAll().isEmpty()) {
                PrintWriter e = new PrintWriter(new FileWriter(this.getFile(path + DigestUtils.md5Hex(resultItems.getRequest().getUrl()) + ".json")));
                e.write(JSON.toJSONString(resultItems.getAll()));
                e.close();
            }
        } catch (IOException var5) {
            logger.warn("write file error", var5);
        }

    }
}
*/
