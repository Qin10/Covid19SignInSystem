package cn.zjutleo.health_server.dto;

import lombok.Data;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: JWT token payload字段DTO
 */
@Data
public class JwtPayloadDto {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户类型
     */
    private Integer typeId;

    /**
     * 用户学号
     */
    private String stuNum;
}
