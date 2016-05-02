package com.xh.framework.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by xh on 2016/4/27.
 */
@MappedSuperclass
public class BaseEntity {
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

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
