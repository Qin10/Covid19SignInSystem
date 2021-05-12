package cn.zjutleo.health_server.util;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 线程数据隔离工具类
 */
public class ThreadLocalUtil {
    private static final ThreadLocal<Integer> CURRENT_USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setCurrentUser(Integer userId) {
        CURRENT_USER_THREAD_LOCAL.set(userId);
    }

    public static Integer getCurrentUser() {
        return CURRENT_USER_THREAD_LOCAL.get();
    }

    public static void removeCurrentUser() {
        CURRENT_USER_THREAD_LOCAL.remove();
    }
}
