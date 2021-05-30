package cn.zjutleo.health_server.mapper;


import java.util.List;



import org.apache.ibatis.annotations.Mapper;

import cn.zjutleo.health_server.pojo.SchoolInfo;
import cn.zjutleo.health_server.pojo.Timecard;
import cn.zjutleo.health_server.pojo.User;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TimecardMapper {
    
    Timecard findTimecardByIdOnToday(@Param("u_id") Integer u_id);
    List<Timecard> findTimecardsSomeDaysAgoById(@Param("u_id") Integer u_id,@Param("days") int days);
    List<User> findUsersNotSignInBySchoolInfoOnToday(SchoolInfo schoolInfo);
    List<Timecard> findTimecardsBySchoolInfoOnToday(SchoolInfo schoolInfo);
    int insert(Timecard timecard);
}