package com.yytech.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * created by wangwang on 2017/12/5 0005
 */
@Setter
@Getter
@NoArgsConstructor
public abstract class BaseModeDO implements Serializable {
    protected long id;
    private Date createTime;
    private Date updateTime;


    public <T extends BaseModeDO> T updateTime() {
        this.updateTime = new Date();
        return (T) this;
    }

    public <T extends BaseModeDO> T id(long id) {
        this.id = id;
        return (T) this;
    }

    public <T extends BaseModeDO> T createTime() {
        this.createTime = new Date();
        return (T) this;
    }
}
