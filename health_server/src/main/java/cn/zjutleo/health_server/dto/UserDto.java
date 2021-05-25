package cn.zjutleo.health_server.dto;

import java.util.Date;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/17
 * @description: 用户DTO
 */
public class UserDto {
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

    public Boolean getuGender() {
        return uGender;
    }

    public void setuGender(Boolean uGender) {
        this.uGender = uGender;
    }

    public Integer getuTypeId() {
        return uTypeId;
    }

    public void setuTypeId(Integer uTypeId) {
        this.uTypeId = uTypeId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public String getuAvatarUrl() {
        return uAvatarUrl;
    }

    public void setuAvatarUrl(String uAvatarUrl) {
        this.uAvatarUrl = uAvatarUrl;
    }

    public String getuSchool() {
        return uSchool;
    }

    public void setuSchool(String uSchool) {
        this.uSchool = uSchool;
    }

    public String getuAcademy() {
        return uAcademy;
    }

    public void setuAcademy(String uAcademy) {
        this.uAcademy = uAcademy;
    }

    public String getuMajor() {
        return uMajor;
    }

    public void setuMajor(String uMajor) {
        this.uMajor = uMajor;
    }

    public Integer getuGrade() {
        return uGrade;
    }

    public void setuGrade(Integer uGrade) {
        this.uGrade = uGrade;
    }

    public String getuClass() {
        return uClass;
    }

    public void setuClass(String uClass) {
        this.uClass = uClass;
    }

    public String getuStuNum() {
        return uStuNum;
    }

    public void setuStuNum(String uStuNum) {
        this.uStuNum = uStuNum;
    }

    public String getuTrueName() {
        return uTrueName;
    }

    public void setuTrueName(String uTrueName) {
        this.uTrueName = uTrueName;
    }

    @Override
    public String toString() {
        return "UserDtoTestIO: User{" +
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
                '}';
    }
}
