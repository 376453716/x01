package com.xh.dynamicsql;

import com.buestc.sys.exception.bean.BaseBizException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 1. init: load xml resource, parse xml put to map
 * 2. process: get sql, process template
 */
public class FreemarkTest {

    private static Configuration cfg;

    private static Map<String, String> dynamicSqlMapper = new HashMap<>();

    private static final String ID_PROPERTIES = "id";
    private static final String NAMESPACE_PROPERTIES = "namespace";

    private static String SQL_TEMPLATE_PATH = "/config/sqlTemplate";
    private static String SQL_TEMPLATE_PATH_PARTTEN = SQL_TEMPLATE_PATH + "/**";

    private static final Logger log = Logger.getLogger(FreemarkTest.class);

    static {
        initFreemarkConfig();
        loadSqlTemplate();
    }

    private static void loadSqlTemplate() {
        try {
            System.out.println("start.....");
            long start = System.currentTimeMillis();
            ClassRelativeResourceLoader resourceLoader = new ClassRelativeResourceLoader(FreemarkTest.class);
            PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(resourceLoader);
            Resource[] resources = resourcePatternResolver.getResources(SQL_TEMPLATE_PATH_PARTTEN);
            for (Resource resource : resources) {
                Map<String, String> map = parseXml2Map(resource);
                dynamicSqlMapper.putAll(map);
            }
            System.out.println("init end===>" + dynamicSqlMapper.keySet());
            long end = System.currentTimeMillis();
            System.out.println("cost===>" + (end - start));
        } catch (Exception e) {
            log.error("", e);
            e.printStackTrace();
        }
    }


    private static Map<String, String> parseXml2Map(Resource resource) throws Exception {
        Map<String, String> map = new HashMap<>();
        InputStream in = resource.getInputStream();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(in);
        Element rootElement = document.getRootElement();
        String nameSpace = rootElement.attribute(NAMESPACE_PROPERTIES).getText();
        Iterator it = rootElement.elementIterator();
        while (it.hasNext()) {
            Element child = (Element) it.next();
            String sqlKey = nameSpace + "." + child.attribute(ID_PROPERTIES).getText();
            if (map.containsKey(sqlKey)) {
                throw new BaseBizException("duplicate key..." + sqlKey + " in " + resource.getFilename());
            } else {
                map.put(sqlKey, StringUtils.trim(child.getText()));
            }
        }
        return map;
    }

    public static ByteArrayOutputStream processTemplate(Class entityClass, String queryName, Map<String, Object> rootContext) throws Exception {
        String sqlKey = entityClass.getName() + "." + queryName;
        String sql = dynamicSqlMapper.get(sqlKey);
        StringReader reader = new StringReader(sql);
        Template temp = new Template(sqlKey, reader, cfg);
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        Writer out = new BufferedWriter(new OutputStreamWriter(arrayOut));
        temp.process(rootContext, out);
        return arrayOut;
    }

    private static void initFreemarkConfig() {
        cfg = new Configuration(Configuration.VERSION_2_3_23);

        try {
            String path = FreemarkTest.class.getResource("/").getPath() + SQL_TEMPLATE_PATH;
            System.out.println("template base ===>" + path);
            cfg.setDirectoryForTemplateLoading(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cfg.setDefaultEncoding("UTF-8");

        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        cfg.setLogTemplateExceptions(false);
    }

}