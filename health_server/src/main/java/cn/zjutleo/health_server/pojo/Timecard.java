package cn.zjutleo.health_server.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timecard {
    private Integer uId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date datetime;
    private String province;
    private String city;
    private String county;
    private String detailLocation;
    private Float temperature;
    private String healthcode;
}
