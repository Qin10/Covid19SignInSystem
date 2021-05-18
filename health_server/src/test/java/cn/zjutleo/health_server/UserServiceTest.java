package cn.zjutleo.health_server;

import cn.zjutleo.health_server.dto.UserDto;
import cn.zjutleo.health_server.exception.apiException.daoException.SelectException;
import cn.zjutleo.health_server.service.UserService;
import cn.zjutleo.health_server.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: UserService测试类
 */
@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;


}
