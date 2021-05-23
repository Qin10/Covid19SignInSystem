package cn.zjutleo.health_server.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zjutleo.health_server.exception.apiException.daoException.InsertException;
import cn.zjutleo.health_server.mapper.TimecardMapper;
import cn.zjutleo.health_server.pojo.SchoolInfo;
import cn.zjutleo.health_server.pojo.Timecard;
import cn.zjutleo.health_server.pojo.User;
@Service
public class TimecardService {
    @Autowired
    TimecardMapper timecardMapper;
    @Autowired 
    RedisService redisService;

    //根据ID获取用户今日打卡信息
    public Timecard getTimecardByIdOnToday(Integer u_id){
        String key="TimecardCache::"+u_id.toString();
        //先在Redis中查询用户打卡信息
        Timecard timecard =(Timecard)redisService.get(key);
        if(timecard==null){
            //redis中找不到则在MySQL中查找
            timecard = timecardMapper.findTimecardByIdOnToday(u_id);
            //如果MySQL中存在用户今日打卡信息，则将其缓存到Redis
            if(timecard!=null){
                redisService.set(key, timecard);
            }
        }
        return timecard;
    }

    //根据ID和天数获取用户以往的打卡信息
    public List<Timecard> getTimecardsSomeDaysAgoById(Integer u_id,int days){
        return timecardMapper.findTimecardsSomeDaysAgoById(u_id, days);
    }
    
    //获取今日未打卡用户的信息
    public List<User> getUsersNotSignInOnToday(SchoolInfo schoolInfo){
        return timecardMapper.findUsersNotSignInBySchoolInfoOnToday(schoolInfo);
    }

    //获取今日所有的打卡信息
    public List<Timecard>getTimecardsBySchoolInfoOnToday(SchoolInfo schoolInfo){
        return timecardMapper.findTimecardsBySchoolInfoOnToday(schoolInfo);
    }
    

    //添加用户打卡到redis和mysql
    public void insert(Timecard timecard) throws InsertException{
        try{
            timecardMapper.insert(timecard);
            redisService.set("TimecardCache::"+timecard.getUId().toString(), timecard);
        }catch(Exception e){
            throw new InsertException();
        }
        
        
        
    }
    
    
}
