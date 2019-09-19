package com.fwzyc.VO;

import java.sql.Date;

public class UserVo {
    private int id;//主键
    private String username;//用户名
    private String password;//密码
    private String sex;//性别  1：男，0：女
    private String address;//用户地址
    private String adddm;//用户地址代码 0：管理员，1：北京，2天津，3：河北，4其他地区
    private Date createtime;//创建时间
    private Date updatetime;//修改时间
    private int isdel;//是否删除（默认值：1） 1：未删除，0：已删除

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdddm() {
        return adddm;
    }

    public void setAdddm(String adddm) {
        this.adddm = adddm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }
}
