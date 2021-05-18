package cn.zjutleo.health_server.util;

import cn.zjutleo.health_server.dto.JwtPayloadDto;
import cn.zjutleo.health_server.vo.UserVo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: JWT令牌颁发工具类
 */
public class JwtUtil {
    /**
     * 校验token是否正确
     *
     * @param token  token令牌
     * @param secret 秘钥
     * @return 是否正确
     */
    public static boolean verify(String token, JwtPayloadDto jwtPayloadDto, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 生成验证对象
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("id", jwtPayloadDto.getId())
                    .withClaim("nickname", jwtPayloadDto.getNickname())
                    .withClaim("typeId", jwtPayloadDto.getTypeId())
                    .withClaim("stuNum", jwtPayloadDto.getStuNum())
                    .build();
            verifier.verify(token);
            return true;
        } catch (TokenExpiredException e) {
            throw e;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的Payload，无需secret解密也能获得
     *
     * @return token中的Payload数据
     */
    public static JwtPayloadDto getPayload(String token) {
        JwtPayloadDto jwtPayloadDto = new JwtPayloadDto();
        try {
            DecodedJWT jwt = JWT.decode(token);
            jwtPayloadDto.setId(jwt.getClaim("id").asInt());
            jwtPayloadDto.setNickname(jwt.getClaim("nickname").asString());
            jwtPayloadDto.setTypeId(jwt.getClaim("typeId").asInt());
            jwtPayloadDto.setStuNum(jwt.getClaim("stuNum").asString());
        } catch (JWTDecodeException | NullPointerException ignored) {

        }
        return jwtPayloadDto;
    }

    /**
     * 根据用户实体类打包payload
     *
     * @param userVo 用户
     * @return payload封装实体
     */
    public static JwtPayloadDto packagePayload(UserVo userVo) {
        JwtPayloadDto jwtPayloadDto = new JwtPayloadDto();
        jwtPayloadDto.setId(userVo.getUId());
        jwtPayloadDto.setNickname(userVo.getUNickname());
        jwtPayloadDto.setTypeId(userVo.getUTypeId());
        jwtPayloadDto.setStuNum(userVo.getUStuNum());
        return jwtPayloadDto;
    }

    /**
     * 生成签名,10分钟后过期
     *
     * @param jwtPayloadDto payload封装实体
     * @param secret        秘钥
     * @return 加密的token
     */
    public static String sign(JwtPayloadDto jwtPayloadDto, String secret, int expireTime) {
        Date date = new Date(System.currentTimeMillis() + (expireTime * 1000L));
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim("id", jwtPayloadDto.getId())
                .withClaim("nickname", jwtPayloadDto.getNickname())
                .withClaim("typeId", jwtPayloadDto.getTypeId())
                .withClaim("stuNum", jwtPayloadDto.getStuNum())
                .withExpiresAt(date)
                .sign(algorithm);
    }
}
