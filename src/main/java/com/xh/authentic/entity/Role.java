package com.xh.authentic.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xh on 2016/4/17.
 */
public class Role {
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

    @Column(name = "deleteFlag")
    private boolean deleteFlag;

    @Column(name = "creator")
    private String creator;

    @Column(name = "modifyer")
    private String modifyer;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "modifyDate")
    private Date modifyDate;

}
