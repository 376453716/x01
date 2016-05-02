package com.xh.dao.test;

import com.xh.authentic.dao.ResourceDao;
import com.xh.authentic.dao.RoleDao;
import com.xh.authentic.dao.UserDao;
import com.xh.authentic.entity.Resource;
import com.xh.authentic.entity.Role;
import com.xh.authentic.entity.User;
import com.xh.util.FreemarkUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by xh on 2016/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application.xml"})
public class DaoTest {

    @Autowired
    RoleDao roleDao;
    @Autowired
    ResourceDao resourceDao;
    @Autowired
    UserDao userDao;

    @Test
    @Transactional
    public void testDao() {
        Resource resource = new Resource();
        resource.setName("fee query");
        resource.setOrder("503");
        resource.setParentId(-1);
        resource.setPermission("fee:query");
        resource.setUrl("");
        resource.setRoles(null);
        resource.setType("1");
        resourceDao.save(resource);

        List<Resource> resources = resourceDao.list("from Resource");
        System.out.println(Arrays.toString(resources.toArray()));

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDao2() {
        try {
            User user = new User();
            user.setName("user 1");
            user.setActive(false);
            user.setEmail("test@test.com");
            user.setPassword("123456");
            user.setPhone("12345678");
            user.setDeleteFlag(false);
            user.setCreateDate(new Date());
            user.setCreator("test");

            List<Role> roles = roleDao.listByPars("from Role where name = ?", "fee admin");
            Set<Role> roleSet = new HashSet<>(roles);
            user.setRoles(roleSet);

            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    @Transactional
    @Rollback(false)
    public void testDao3() {
        try {
            User user = userDao.get(13l);
            Set<Role> roleSet = user.getRoles();
            for (Role role : roleSet) {
                for (Resource resource : role.getResources()) {
                    System.out.println(resource.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    /*@Transactional
    @Rollback(false)*/
    public void testDao4() {
        try {
            User user = new User();
            user.setId(13l);
            user.setName("user");
            user.setActive(true);
            String hql = FreemarkUtil.processTemplate("UserMapper.xml", user);
            System.out.println("hql===>" + hql);
            List<User> users = userDao.listByExecuteHQL(hql);
            System.out.println(users.get(0).getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
