package cn.mingyu.springbootcache.service;

import cn.mingyu.springbootcache.entity.Employee;

import java.util.List;

/**
 * ClassName: EmployeeService
 * Description:
 * date: 2021/12/12 下午10:31
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */

public interface EmployeeService {
    Employee getEmployeeById(int id);

    int addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    int deleteEmployee(int id);
}
