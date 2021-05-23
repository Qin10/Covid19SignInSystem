package cn.zjutleo.health_server.service;

import cn.hutool.core.bean.BeanUtil;
import cn.zjutleo.health_server.dto.UserDto;
import cn.zjutleo.health_server.exception.apiException.daoException.SelectException;
import cn.zjutleo.health_server.mapper.UserMapper;
import cn.zjutleo.health_server.pojo.User;
import cn.zjutleo.health_server.vo.PageVo;
import cn.zjutleo.health_server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 用户服务类
 */
@Slf4j
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

    /**
     * 根据用户id更新用户公有信息
     *
     * @param userDto
     * @param userId
     */
    public void updateUserByUserId(UserDto userDto, Integer userId) throws SelectException {
        log.info(userDto.toString());
        log.info(String.valueOf(userId));
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setUId(userId);
        userMapper.updateByUId(user, userId);
    }

    /**
     * 获取所有用户id
     *
     * @return 所有用户id列表
     */
    public List<Integer> getAllUserId(){
        return userMapper.selectUId();
    }

    /**
     * 分页获取所有用户信息列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageVo<List<UserVo>> getAllUserVoPageable(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<UserVo> userVos = userMapper.selectAll();
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
        return new PageVo<>(pageInfo.getPageNum(), pageInfo.getSize(), pageInfo.getList());
    }

}
