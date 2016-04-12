package com.xh.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by xh on 07/03/16.
 */
public class HelloCustomer implements MessageListener {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //初始化ConnectionFactory
                    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
                    //创建mq连接
                    Connection conn = connectionFactory.createConnection();
                    //启动连接
                    conn.start();
                    //创建会话
                    Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
                    //通过会话创建目标
                    Destination dest = session.createQueue("test");
                    //创建mq消息的消费者
                    MessageConsumer consumer = session.createConsumer(dest);
                    //初始化MessageListener
                    //给消费者设定监听对象
                    consumer.setMessageListener(new HelloCustomer());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.currentThread().sleep(100000l);

    }

    @Test
    public void testCustomer() throws Exception {
        //初始化ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        //创建mq连接
        Connection conn = connectionFactory.createConnection();
        //启动连接
        conn.start();
        //创建会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //通过会话创建目标
        Topic dest = session.createTopic("testTopic");
        //创建mq消息的消费者
        TopicSubscriber subscriber = session.createDurableSubscriber(dest, "testTopic");
        //初始化MessageListener
        //给消费者设定监听对象
        subscriber.setMessageListener(new HelloCustomer());
        while (true) {
            Thread.currentThread().sleep(1000);
        }
    }

    @After
    public void clean() {

    }

    @Override
    public void onMessage(Message message) {
        if (TextMessage.class.isInstance(message))
            try {
                System.out.println("message" + ((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
    }
}
