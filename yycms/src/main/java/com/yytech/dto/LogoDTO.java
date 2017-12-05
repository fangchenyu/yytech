package com.yytech.dto;

public class LogoDTO {
    private int id;
    private int parentid;
    private String name;
    private String content;
    private long createtime;
    private int del;

    @Override
    public String toString() {
        return "LogoDTO{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    public LogoDTO() {
    }

    public int getParentid() {
        return parentid;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public long getCreatetime() {
        return createtime;
    }

    public int getDel() {
        return del;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public void setDel(int del) {
        this.del = del;
    }
}
