package com.xh.Entity;

import com.xh.authentic.entity.User;
import com.xh.util.XCommonUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * Created by xionghao on 30/10/2015.
 */
public class XFreemarkTest {

    private final static Logger log = Logger.getLogger(XFreemarkTest.class);

    private static Configuration cfg;

    /**
     * Do not needlessly re-create Configuration instances;
     * it's expensive, among others because you lose the caches.
     * Configuration instances meant to application-level singletons
     */
    @BeforeClass
    public static void init() {
        try {
            // Create your Configuration instance, and specify if up to what FreeMarker
            // version (here 2.3.22) do you want to apply the fixes that are not 100%
            // backward-compatible. See the Configuration JavaDoc for details.
            cfg = new Configuration(Configuration.VERSION_2_3_22);
            // Specify the source where the template files come from. Here I set a
            // plain directory for it, but non-file-system sources are possible too:2
            String templatePath = XCommonUtil.getClassFilePath("/") + "freemark";
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

    @Test
    public void test() {
        try {
            // Configuration caches Template instances when you get test.ftl again,
            // it probably won't read and parse the template file again,
            // just returns the same Template instance as for the first time.
            Template template = cfg.getTemplate("f01.ftl");

            Map<String, Object> root = createDataModel();

            Writer out = new OutputStreamWriter(System.out);

            template.process(root, out);
            // data-model + template = output
        } catch (IOException e) {
            log.error("Templates Io Exception(f01.ftl)", e);
        } catch (TemplateException e) {
            log.error("Write Template Exception(f01.ftl)", e);
        }

    }

    private Map<String, Object> createDataModel() {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("data", "simple data model");
        User user = new User();
        List<User> users = createUsers(5);
        root.put("user", user);
        root.put("users", null);
        root.put("price", 0);
        return root;
    }

    private List<User> createUsers(int capacity) {
        List<User> users = new ArrayList<User>(capacity);
        Date date = new Date();
        for (int i = 0; i < capacity; i++) {
            User temp = new User();
            users.add(temp);
        }
        return users;
    }
}
