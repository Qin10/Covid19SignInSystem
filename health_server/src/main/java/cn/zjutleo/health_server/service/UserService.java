package cn.zjutleo.health_server.service;

import cn.zjutleo.health_server.exception.apiException.daoException.SelectException;
import cn.zjutleo.health_server.mapper.UserMapper;
import cn.zjutleo.health_server.pojo.User;
import cn.zjutleo.health_server.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 用户服务类
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据id查找用户，如果未找到则抛出异常
     *
     * @param id 用户id
     * @return 用户
     * @throws SelectException 查询异常
     */
    public UserVo getExistUserVoById(int id) throws SelectException {
        UserVo userVo = userMapper.selectVoByPrimaryKey(id);
        if(userVo == null){
            throw new SelectException("用户不存在！");
        } else {
            return userVo;
        }
    }

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return 用户
     */
    public UserVo getUserVoById(int id){
        return userMapper.selectVoByPrimaryKey(id);
    }

    /**
     * 保存用户
     *
     * @param user 用户实体类
     */
    public void saveUser(User user){
        userMapper.insertSelective(user);
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     */
    public void deleteUserById(int id){
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 判断id是否存在
     *
     * @param userId
     * @return
     */
    public boolean existsById(Integer userId) {
        return userId != null && userMapper.selectIdById(userId) != null;
    }
}
