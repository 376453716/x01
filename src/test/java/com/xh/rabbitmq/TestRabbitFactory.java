package com.xh.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.xh.util.LoadProperties;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
 * @author Xiong Hao
 */
public class TestRabbitFactory {

    private static final Logger log = Logger.getLogger(TestRabbitFactory.class);

    private static Properties rabbitProperties = LoadProperties.load("rabbit/rabbit.properties");

    public static final String RABBIT_HOST = (String) rabbitProperties.get("rabbit.host");
    public static final String RABBIT_USER = (String) rabbitProperties.get("rabbit.user");
    public static final String RABBIT_PASSWORD = (String) rabbitProperties.get("rabbit.password");

    /**
     * 创建MQ连接
     *
     * @return
     */
    public static Connection createConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RABBIT_HOST);
        factory.setUsername(RABBIT_USER);
        factory.setPassword(RABBIT_PASSWORD);
        try {
            Connection connection = factory.newConnection();
            return connection;
        } catch (IOException | TimeoutException e) {
            log.error("", e);
            throw new RuntimeException("", e);
        }
    }

    /**
     * 关闭MQ连接
     *
     * @param connection
     */
    public static void closeConnenction(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (IOException e) {
                log.error("", e);
            }
        }
    }
}
