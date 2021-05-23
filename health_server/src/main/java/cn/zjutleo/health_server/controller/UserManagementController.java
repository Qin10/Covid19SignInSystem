package cn.zjutleo.health_server.controller;

import cn.zjutleo.health_server.annotation.RequiresLogin;
import cn.zjutleo.health_server.service.UserService;
import cn.zjutleo.health_server.vo.PageVo;
import cn.zjutleo.health_server.vo.ResponseBean;
import cn.zjutleo.health_server.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/23
 * @description: 用户管理相关请求类
 */
@RestController
@RequestMapping("/admin/user")
public class UserManagementController {
    @Resource
    private UserService userService;

    /**
     * 分页获取所有用户信息
     *
     * @param pageNum 页码
     * @param pageSize 分页大小
     * @return
     */
    @RequiresLogin(requiresRoles = "0")
    @GetMapping()
    public ResponseBean<PageVo<List<UserVo>>> getAllUserVoPageable(@RequestParam(value = "pageNum") int pageNum, @RequestParam(value = "pageSize") int pageSize){
        PageVo<List<UserVo>> userVos = userService.getAllUserVoPageable(pageNum, pageSize);
        return new ResponseBean<>(200, "succ", userVos);
    }

    /**
     * 根据用户id删除用户
     *
     * @param userId
     * @return
     */
    @RequiresLogin(requiresRoles = "0")
    @DeleteMapping("/{userId}")
    public ResponseBean<Object> deleteUser(@PathVariable("userId") int userId){
        userService.deleteUserById(userId);
        return new ResponseBean<>(200, "succ", null);
    }
}
