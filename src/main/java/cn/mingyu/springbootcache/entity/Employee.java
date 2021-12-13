package cn.mingyu.springbootcache.entity;

import lombok.Data;

/**
 * ClassName: Employment
 * Description:
 * date: 2021/12/12 下午10:16
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
