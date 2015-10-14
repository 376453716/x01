package com.xh.Entity;

import com.xh.common.XUtils;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by xh on 15/3/1.
 */

@Entity
@Table(name = "user")
public class User {
    private long id;
    private String name;
    private Date birthday;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + XUtils.fomateDate(birthday) +
                '}';
    }
}
