package com.xh.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xh on 2016/5/2.
 */
public class FreemarkUtil {

    private final static Logger log = Logger.getLogger(FreemarkUtil.class);

    private static Configuration cfg;

    public static String processTemplate(String templateName, Object param) {
        try {
            // Configuration caches Template instances when you get test.ftl again,
            // it probably won't read and parse the template file again,
            // just returns the same Template instance as for the first time.
            Template template = cfg.getTemplate(templateName);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Writer out = new OutputStreamWriter(byteArrayOutputStream);

            Map<String, Object> root = new HashMap<String, Object>();
            root.put("user", param);
            template.process(root, out);

            return byteArrayOutputStream.toString();
            // data-model + template = output
        } catch (IOException e) {
            log.error("Templates Io Exception(f01.ftl)", e);
        } catch (TemplateException e) {
            log.error("Write Template Exception(f01.ftl)", e);
        }
        return null;
    }

    static {
        try {
            // Create your Configuration instance, and specify if up to what FreeMarker
            // version (here 2.3.22) do you want to apply the fixes that are not 100%
            // backward-compatible. See the Configuration JavaDoc for details.
            cfg = new Configuration(Configuration.VERSION_2_3_22);
            // Specify the source where the template files come from. Here I set a
            // plain directory for it, but non-file-system sources are possible too:2
            String templatePath = XCommonUtil.getClassFilePath("/") + "freemark/sql";
            cfg.setDirectoryForTemplateLoading(new File(templatePath));
            // Set the preferred charset template files are stored in. UTF-8 is
            // a good choice in most applications:
            cfg.setDefaultEncoding("UTF-8");
            // Sets how errors will appear.
            // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            //Date format
            cfg.setTimeFormat("HH:mm:ss");
            cfg.setDateFormat("dd/mm/yyyy");
            cfg.setDateTimeFormat("dd/mm/yyyy HH:mm:ss ");
        } catch (IOException e) {
            log.error("Templates Io Exception", e);
        }
    }
}
