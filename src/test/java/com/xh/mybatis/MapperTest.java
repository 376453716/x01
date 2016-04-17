package com.xh.mybatis;

import com.xh.authentic.entity.User;
import com.xh.dao.MessageDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

/**
 * Created by xh on 27/12/15.
 */
public class MapperTest {

    final static Logger log = LoggerFactory.getLogger(MapperTest.class);

    @Test
    public void test1() {
        try (InputStream resources = Resources.getResourceAsStream("com/xh/dao/mybatisConfiguration.xml");) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resources, "DEV");
            try (SqlSession session = factory.openSession();) {
                User user = session.selectOne("getEntity", 1l);
                log.info(user.toString());
                user.setName("eee");
                session.update("updateEntity", user);
                user = session.selectOne("getEntity", 1l);
                log.info(user.toString());
                session.commit();
            } catch (Exception sqlException) {
                log.error("", sqlException);
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @Test
    public void test2() {
        try (InputStream resources = Resources.getResourceAsStream("com/xh/dao/mybatisConfiguration.xml");) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resources);
            try (SqlSession session = factory.openSession();) {
                MessageDao dao = session.getMapper(MessageDao.class);
                List<User> list = dao.listEntity();
                log.info(list.toString());
            } catch (Exception sqlException) {
                log.error("", sqlException);
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
