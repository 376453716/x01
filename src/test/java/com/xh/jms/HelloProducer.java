package com.xh.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by xh on 07/03/16.
 */
public class HelloProducer {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    try {
                        //初始化连接工厂
                        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
                        //获得连接
                        Connection conn = connectionFactory.createConnection();
                        //启动连接
                        conn.start();
                        //创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
                        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
                        //创建队列
                        Destination dest = session.createQueue("test");
                        //createTopic方法用来创建Topic
                        //session.createTopic("TOPIC");

                        //通过session可以创建消息的生产者
                        MessageProducer producer = session.createProducer(dest);
                        for (int i = 0; i < 100; i++) {
                            //初始化一个mq消息
                            TextMessage message = session.createTextMessage("hello active mq 中文" + i);
                            //发送消息
                            producer.send(message);
                            System.out.println("send message {}" + i);
                        }

                        //关闭mq连接
                        conn.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Test
    public void publish() throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

        Connection connection = factory.createConnection();

        connection.start();

        //Session session = connection.createTopic("testTopic");
    }


}
