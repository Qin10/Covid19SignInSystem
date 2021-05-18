package cn.zjutleo.health_server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/16
 * @description: 分页封装VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {
    /**
     * 页码
     */
    private int pageNum;

    /**
     * 分页大小
     */
    private int pageSize;

    /**
     * 内容
     */
    private T pageData;
}
