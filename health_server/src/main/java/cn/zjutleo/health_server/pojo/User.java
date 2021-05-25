package cn.zjutleo.health_server.pojo;

import java.util.Date;
import lombok.Data;

public class User {
    private Integer uId;

    /**
    * 用户昵称
    */
    private String uNickname;

    /**
    * 用户性别(1:男, 0:女)
    */
    private Boolean uGender;

    /**
    * 用户类别
    */
    private Integer uTypeId;

    /**
    * 用户头像文件保存路径
    */
    private String uAvatarUrl;

    /**
    * 用户学校
    */
    private String uSchool;

    /**
    * 用户学院
    */
    private String uAcademy;

    /**
    * 用户主修专业
    */
    private String uMajor;

    /**
    * 用户当前年级
    */
    private Integer uGrade;

    /**
    * 用户当前班级
    */
    private String uClass;

    /**
    * 用户学号
    */
    private String uStuNum;

    /**
    * 用户真实姓名
    */
    private String uTrueName;

    /**
    * 账户首次登录时间
    */
    private Date uCreatedTime;

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUNickname() {
        return uNickname;
    }

    public void setUNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public Boolean getUGender() {
        return uGender;
    }

    public void setUGender(Boolean uGender) {
        this.uGender = uGender;
    }

    public Integer getUTypeId() {
        return uTypeId;
    }

    public void setUTypeId(Integer uTypeId) {
        this.uTypeId = uTypeId;
    }

    public String getUAvatarUrl() {
        return uAvatarUrl;
    }

    public void setUAvatarUrl(String uAvatarUrl) {
        this.uAvatarUrl = uAvatarUrl;
    }

    public String getUSchool() {
        return uSchool;
    }

    public void setUSchool(String uSchool) {
        this.uSchool = uSchool;
    }

    public String getUAcademy() {
        return uAcademy;
    }

    public void setUAcademy(String uAcademy) {
        this.uAcademy = uAcademy;
    }

    public String getUMajor() {
        return uMajor;
    }

    public void setUMajor(String uMajor) {
        this.uMajor = uMajor;
    }

    public Integer getUGrade() {
        return uGrade;
    }

    public void setUGrade(Integer uGrade) {
        this.uGrade = uGrade;
    }

    public String getUClass() {
        return uClass;
    }

    public void setUClass(String uClass) {
        this.uClass = uClass;
    }

    public String getUStuNum() {
        return uStuNum;
    }

    public void setUStuNum(String uStuNum) {
        this.uStuNum = uStuNum;
    }

    public String getUTrueName() {
        return uTrueName;
    }

    public void setUTrueName(String uTrueName) {
        this.uTrueName = uTrueName;
    }

    public Date getUCreatedTime() {
        return uCreatedTime;
    }

    public void setUCreatedTime(Date uCreatedTime) {
        this.uCreatedTime = uCreatedTime;
    }

    @Override
    public String toString() {
        return "UserTestIO: User{" +
                "uId=" + uId +
                ", uNickname='" + uNickname + '\'' +
                ", uGender=" + uGender +
                ", uTypeId=" + uTypeId +
                ", uAvatarUrl='" + uAvatarUrl + '\'' +
                ", uSchool='" + uSchool + '\'' +
                ", uAcademy='" + uAcademy + '\'' +
                ", uMajor='" + uMajor + '\'' +
                ", uGrade=" + uGrade +
                ", uClass='" + uClass + '\'' +
                ", uStuNum='" + uStuNum + '\'' +
                ", uTrueName='" + uTrueName + '\'' +
                ", uCreatedTime=" + uCreatedTime +
                '}';
    }
}