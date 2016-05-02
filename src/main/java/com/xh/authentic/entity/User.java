package com.xh.authentic.entity;

import com.xh.framework.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by xh on 2016/4/17.
 */
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity {
    @Id
    @TableGenerator(
            name = "id_generator",
            table = "seq_t",
            pkColumnName = "keyName",
            valueColumnName = "keyValue",
            pkColumnValue = "seq_tb_user",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Column(name = "ID")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private boolean active;
    @Column(name = "birthday")
    private Date birthday;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "tb_user_roles", joinColumns = @JoinColumn(name = "userIds"),
            inverseJoinColumns = @JoinColumn(name = "roleIds"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
