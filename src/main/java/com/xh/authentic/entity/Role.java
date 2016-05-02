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
@Table(name = "tb_role")
public class Role extends BaseEntity {
    @Id
    @TableGenerator(
            name = "id_generator",
            table = "seq_t",
            pkColumnName = "keyName",
            valueColumnName = "keyValue",
            pkColumnValue = "seq_tb_role",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Column(name = "ID")
    private Long roleId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(targetEntity = Resource.class)
    @JoinTable(name = "tb_role_resource", joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "resourceId"))
    private Set<Resource> resources;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
