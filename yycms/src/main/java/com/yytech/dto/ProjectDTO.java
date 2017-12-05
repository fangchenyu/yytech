package com.yytech.dto;

public class ProjectDTO {
    private int id;
    private int subtitleid; //二级标题id
    private String title;//标题
    private String synopsis;//项目简介
    private String cncontent;//中文介绍
    private String engcontent;//英文介绍
    private long createtime;
    private int del;

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", subtitleid=" + subtitleid +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", cncontent='" + cncontent + '\'' +
                ", engcontent='" + engcontent + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    public ProjectDTO() {

    }

    public int getSubtitleid() {
        return subtitleid;
    }

    public void setSubtitleid(int subtitleid) {
        this.subtitleid = subtitleid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCncontent() {
        return cncontent;
    }

    public void setCncontent(String cncontent) {
        this.cncontent = cncontent;
    }

    public String getEngcontent() {
        return engcontent;
    }

    public void setEngcontent(String engcontent) {
        this.engcontent = engcontent;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
}
