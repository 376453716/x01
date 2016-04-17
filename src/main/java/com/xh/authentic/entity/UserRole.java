package com.xh.authentic.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Created by xh on 2016/4/17.
 */
@Entity
@Table(name = "tb_user_role")
public class UserRole {

    @Id
    @TableGenerator(
            name = "id_generator",
            table = "seq_t",
            pkColumnName = "keyName",
            valueColumnName = "keyValue",
            pkColumnValue = "seq_tb_user_role",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Column(name = "userRoleId")
    private Long userRoleId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "roleId")
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private User user;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
