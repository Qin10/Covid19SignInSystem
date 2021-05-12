package cn.zjutleo.health_server.mapper;

import cn.zjutleo.health_server.pojo.User;
import cn.zjutleo.health_server.vo.UserVo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    UserVo selectVoByPrimaryKey(Integer id);

    Integer selectIdById(Integer id);
}