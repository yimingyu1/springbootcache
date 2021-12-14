package cn.mingyu.springbootcache.controller;

import cn.mingyu.springbootcache.entity.Employee;
import cn.mingyu.springbootcache.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: EmployeeContorller
 * Description:
 * date: 2021/12/12 下午10:35
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping(path = "getEmployeeById")
    public Employee getEmployee(@RequestParam(name = "id") Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "updateEmployee")
    public Employee updateEmployee(@RequestParam(name = "id") Integer id){
        Employee employee = employeeService.getEmployeeById(id);
        employee.setLastName("李四");
        Employee newEmployee = employeeService.updateEmployee(employee);
        return newEmployee;
    }

    @GetMapping(path = "deleteEmployee")
    public Integer deleteEmployee(@RequestParam(name = "id") Integer id){
        return employeeService.deleteEmployee(id);
    }


}
