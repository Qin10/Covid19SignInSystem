package cn.zjutleo.health_server.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zjutleo.health_server.pojo.SchoolInfo;
import cn.zjutleo.health_server.pojo.Timecard;
import cn.zjutleo.health_server.pojo.User;
import cn.zjutleo.health_server.service.TimecardService;

@RestController
public class TimecardController {
    @Autowired
    TimecardService timecardService;

    //前端发送用户ID值获取用户今日打卡信息
    @ResponseBody
    @PostMapping(value = "/query/timecardByIdOnToday")
    public Timecard queryTimecardByIdOnToday(@RequestBody Map<String,Object> map){
        Integer u_id =(Integer)(map.get("u_id"));
        return timecardService.getTimecardByIdOnToday(u_id);
    }

    //前端发送用户ID和天数获取前几天用户打卡信息
    @ResponseBody
    @PostMapping(value="/query/timecardsSomeDaysAgoById")
    public List<Timecard> queryTimecardSomeDaysAgoById(@RequestBody Map<String,Object> map){
        Integer u_id =(Integer)(map.get("u_id"));
        int days =(Integer)(map.get("days"));
        return timecardService.getTimecardsSomeDaysAgoById(u_id, days);
    }

    //前端发送用户学校的JSON数据，后端通过该数据获取今日未打卡的用户信息
    @ResponseBody
    @PostMapping(value="/query/usersNotSignInOnToday")
    public List<User> queryUsersNotSignInOnToday(@RequestBody SchoolInfo schoolInfo){
        return timecardService.getUsersNotSignInOnToday(schoolInfo);
    }

    //前端发送用户学校的JSON数据，后端通过该数据获取今日的打卡信息
    @ResponseBody
    @PostMapping(value="/query/timecardsBySchoolInfoOnToday")
    public List<Timecard> queryTimecardsBySchoolInfoOnToday(@RequestBody SchoolInfo schoolInfo){
        return timecardService.getTimecardsBySchoolInfoOnToday(schoolInfo);
    }

    /*前端发送Timecard中除datetime的其他相关信息，后端根据map获取其他信息
    后端封装Timecard后添加*/
    @PostMapping(value="/addTimecard")
    public String addTimecard(@RequestBody Map<String,Object> map){
        Integer u_id=(Integer)map.get("u_id");
        if(timecardService.getTimecardByIdOnToday(u_id)!=null){
            return "您已打卡成功，请勿重复打卡" ;
        }else{
            Date datetime = new Date();
            String province=(String)map.get("province");
            String city=(String)map.get("city");
            String county=(String) map.get("county");
            String detailLocation=(String) map.get("detailLocaiton");
            Float temperature=((Double)map.get("temperature")).floatValue();
            String healthcode=(String) map.get("healthcode");
            Timecard timecard = new Timecard(u_id,datetime,province,city,county,detailLocation,temperature,healthcode);
            timecardService.insert(timecard);
            return "打卡成功";
        }

    }
}
