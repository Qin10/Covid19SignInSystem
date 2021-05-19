package cn.zjutleo.health_server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolInfo {
    private String school;
    private String academy;
    private String major;
    private Integer grade;
    private String classe;
}
