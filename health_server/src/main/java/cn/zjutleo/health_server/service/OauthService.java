package cn.zjutleo.health_server.service;

import cn.zjutleo.health_server.mapper.OauthMapper;
import cn.zjutleo.health_server.pojo.Oauth;
import cn.zjutleo.health_server.vo.OauthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 第三方登录服务类
 */
@Service
public class OauthService {
    @Autowired
    private OauthMapper oauthMapper;

    /**
     * 根据第三方凭证类型和凭证号码获取凭证实体
     *
     * @param oauthType 第三方凭证类型
     * @param oauthId   第三方凭证编号
     * @return 第三方登录凭证
     */
    public Oauth getOauthByOauthTypeAndOauthId(String oauthType, String oauthId) {
        return oauthMapper.selectByOauthTypeAndOauthId(oauthType, oauthId);
    }

    /**
     * 根据第三方凭证类型和用户id获取凭证实体
     *
     * @param oauthType 第三方凭证类型
     * @param userId    用户id
     * @return 第三方登录凭证
     */
    public Oauth getOauthByOauthTypeAndUserId(String oauthType, Integer userId) {
        return oauthMapper.selectByPrimaryKey(userId, oauthType);
    }

    /**
     * 根据用户id获取全部第三方登录凭证VO
     *
     * @param userId 用户id
     * @return 第三方登录凭证VO
     */
    public List<OauthVo> getAllOauthVoByUserId(Integer userId) {
        return oauthMapper.selectAllVoByUserId(userId);
    }

    /**
     * 保存第三方凭证
     *
     * @param oauth 第三方凭证
     */
    public void saveOauth(Oauth oauth) {
        oauthMapper.insertSelective(oauth);
    }
}
