package cn.zjutleo.health_server.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.zjutleo.health_server.annotation.RequestLimit;
import cn.zjutleo.health_server.annotation.RequiresLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zjutleo.health_server.exception.apiException.daoException.InsertException;
import cn.zjutleo.health_server.pojo.SchoolInfo;
import cn.zjutleo.health_server.pojo.Timecard;
import cn.zjutleo.health_server.pojo.User;
import cn.zjutleo.health_server.service.TimecardService;
import cn.zjutleo.health_server.vo.ResponseBean;
@Slf4j
@RestController
public class TimecardController {
    @Autowired
    TimecardService timecardService;

    //前端发送用户ID值获取用户今日打卡信息
    @RequestLimit
    @RequiresLogin
    @PostMapping(value = "/query/timecardByIdOnToday")
    public ResponseBean<Timecard> queryTimecardByIdOnToday(@RequestBody Map<String,Object> map){
        Integer u_id =(Integer)(map.get("u_id"));
        return new ResponseBean<>(200, "succ", timecardService.getTimecardByIdOnToday(u_id)) ;
    }

    //前端发送用户ID和天数获取前几天用户打卡信息
    @RequestLimit
    @RequiresLogin
    @PostMapping(value="/query/timecardsSomeDaysAgoById")
    public ResponseBean<List<Timecard>> queryTimecardSomeDaysAgoById(@RequestBody Map<String,Object> map){
        Integer u_id =(Integer)(map.get("u_id"));
        int days =(Integer)(map.get("days"));
        return new ResponseBean<>(200, "succ", timecardService.getTimecardsSomeDaysAgoById(u_id, days));
    }

    //前端发送用户学校的JSON数据，后端通过该数据获取今日未打卡的用户信息
    @RequestLimit
    @RequiresLogin
    @PostMapping(value="/query/usersNotSignInOnToday")
    public ResponseBean<List<User>> queryUsersNotSignInOnToday(@RequestBody SchoolInfo schoolInfo){
        return new ResponseBean<>(200, "succ", timecardService.getUsersNotSignInOnToday(schoolInfo));
    }

    //前端发送用户学校的JSON数据，后端通过该数据获取今日的打卡信息
    @RequestLimit
    @RequiresLogin
    @PostMapping(value="/query/timecardsBySchoolInfoOnToday")
    public ResponseBean<List<Timecard>> queryTimecardsBySchoolInfoOnToday(@RequestBody SchoolInfo schoolInfo){

        return new ResponseBean<>(200, "succ", timecardService.getTimecardsBySchoolInfoOnToday(schoolInfo));
    }

    /*前端发送Timecard中除datetime的其他相关信息，后端根据map获取其他信息
    后端封装Timecard后添加*/
    @RequestLimit
    @RequiresLogin
    @PostMapping(value="/addTimecard")
    public ResponseBean<String> addTimecard(@RequestBody Map<String,Object> map) throws InsertException {
        Integer u_id=(Integer)map.get("u_id");
        log.info(u_id.toString());
        if(timecardService.getTimecardByIdOnToday(u_id)!=null){
            return new ResponseBean<> (200, "succ", "您已打卡成功，请勿重复打卡") ;
        }else{
            Date datetime = new Date();
            String province=(String)map.get("province");
            String city=(String)map.get("city");
            String county=(String) map.get("county");
            String detailLocation=(String) map.get("detailLocation");
            Float temperature=((Double)map.get("temperature")).floatValue();
            String healthcode=(String) map.get("healthcode");
            Timecard timecard = new Timecard(u_id,datetime,province,city,county,detailLocation,temperature,healthcode);
            timecardService.insert(timecard);
            return new ResponseBean<>(200, "succ", "打卡成功");
        }

    }
}
