package cn.zjutleo.health_server.vo;

import java.util.Date;
import lombok.Data;

@Data
public class UserVo {
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


}