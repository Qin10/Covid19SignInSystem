package cn.zjutleo.health_server.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zjutleo.health_server.exception.apiException.daoException.InsertException;
import cn.zjutleo.health_server.pojo.SchoolInfo;
import cn.zjutleo.health_server.pojo.Timecard;
import cn.zjutleo.health_server.pojo.User;
import cn.zjutleo.health_server.service.TimecardService;
import cn.zjutleo.health_server.vo.ResponseBean;

@RestController
public class TimecardController {
    @Autowired
    TimecardService timecardService;

    //前端发送用户ID值获取用户今日打卡信息
    @PostMapping(value = "/query/timecardByIdOnToday")
    public ResponseBean<Timecard> queryTimecardByIdOnToday(@RequestBody Map<String,Object> map){
        Integer u_id =(Integer)(map.get("u_id"));
        return new ResponseBean<Timecard>(timecardService.getTimecardByIdOnToday(u_id)) ;
    }

    //前端发送用户ID和天数获取前几天用户打卡信息
    @PostMapping(value="/query/timecardsSomeDaysAgoById")
    public ResponseBean<List<Timecard>> queryTimecardSomeDaysAgoById(@RequestBody Map<String,Object> map){
        Integer u_id =(Integer)(map.get("u_id"));
        int days =(Integer)(map.get("days"));
        return new ResponseBean<List<Timecard>>(timecardService.getTimecardsSomeDaysAgoById(u_id, days));
    }

    //前端发送用户学校的JSON数据，后端通过该数据获取今日未打卡的用户信息
    @PostMapping(value="/query/usersNotSignInOnToday")
    public ResponseBean<List<User>> queryUsersNotSignInOnToday(@RequestBody SchoolInfo schoolInfo){
        return new ResponseBean<List<User>>(timecardService.getUsersNotSignInOnToday(schoolInfo));
    }

    //前端发送用户学校的JSON数据，后端通过该数据获取今日的打卡信息
    @PostMapping(value="/query/timecardsBySchoolInfoOnToday")
    public ResponseBean<List<Timecard>> queryTimecardsBySchoolInfoOnToday(@RequestBody SchoolInfo schoolInfo){
    
        return new ResponseBean<List<Timecard>>(timecardService.getTimecardsBySchoolInfoOnToday(schoolInfo));
    }

    /*前端发送Timecard中除datetime的其他相关信息，后端根据map获取其他信息
    后端封装Timecard后添加*/
    @PostMapping(value="/addTimecard")
    public ResponseBean<String> addTimecard(@RequestBody Map<String,Object> map){
        Integer u_id=(Integer)map.get("u_id");
        if(timecardService.getTimecardByIdOnToday(u_id)!=null){
            return new ResponseBean<String> ("您已打卡成功，请勿重复打卡") ;
        }else{
            Date datetime = new Date();
            String province=(String)map.get("province");
            String city=(String)map.get("city");
            String county=(String) map.get("county");
            String detailLocation=(String) map.get("detailLocation");
            Float temperature=((Double)map.get("temperature")).floatValue();
            String healthcode=(String) map.get("healthcode");
            Timecard timecard = new Timecard(u_id,datetime,province,city,county,detailLocation,temperature,healthcode);
            try{
                timecardService.insert(timecard);
            }catch (InsertException e){
                return new ResponseBean<String>("打卡失败，用户id可能不存在");
            }
            return new ResponseBean<String>("打卡成功");
        }

    }
}