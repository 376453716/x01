package com.xh.authentic.entity;

import com.xh.framework.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by xh on 2016/4/27.
 */
@Entity
@Table(name = "tb_resources")
public class Resource extends BaseEntity {

    @Id
    @TableGenerator(
            name = "id_generator",
            table = "seq_t",
            pkColumnName = "keyName",
            valueColumnName = "keyValue",
            pkColumnValue = "seq_tb_resource",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Column(name = "ID")
    private long resourceId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;

    @Column(name = "permission")
    private String permission;

    @Column(name = "parentId")
    private int parentId;

    @Column(name = "orderStr")
    private String order;

    @ManyToMany(mappedBy = "resources")
    private Set<Role> roles;


    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
