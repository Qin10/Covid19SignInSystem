package cn.zjutleo.health_server.constants;

import lombok.Getter;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 错误码枚举
 */
@Getter
public enum ApiExceptionCodes {
    /**
     * 未找到token
     */
    TOKEN_NOT_FOUND(101, "未找到token！"),
    /**
     * token校验失败
     */
    TOKEN_CHECK_FAIL(102, "token校验失败！"),
    /**
     * token已过期
     */
    TOKEN_EXPIRED(103, "token已过期！"),
    /**
     * 无权限访问
     */
    ACCESS_FORBIDDEN(104, "无权限访问！"),
    /**
     * 无权限操作
     */
    PERMISSION_DENIED(105, "无权限操作！"),
    /**
     * 用户不存在
     */
    USER_NOT_FOUND(301, "用户不存在！"),
    /**
     * 该用户已经存在
     */
    ACCOUNT_EXISTED(302, "该用户已经存在！"),
    /**
     * 创建失败
     */
    INSERT_ERROR(401, "创建失败！"),
    /**
     * 修改失败
     */
    UPDATE_ERROR(402, "修改失败！"),
    /**
     * 删除失败
     */
    DELETE_ERROR(403, "删除失败"),
    /**
     * 未找到结果
     */
    SELECT_ERROR(404, "未找到结果！"),
    /**
     * 参数校验失败
     */
    ARGUMENTS_VALID_FAIL(501, "参数校验失败！"),
    /**
     * 访问次数超限
     */
    REQUEST_TIMES_EXCEEDED(601, "访问次数超限！"),
    /**
     * 授权失败
     */
    AUTHORIZATION_FAIL(701, "授权失败！");

    private final Integer value;
    private final String desc;

    ApiExceptionCodes(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
