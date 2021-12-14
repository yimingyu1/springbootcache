package cn.mingyu.springbootcache.service;

import cn.mingyu.springbootcache.dao.EmploymentDao;
import cn.mingyu.springbootcache.entity.Employee;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: EmployeeServiceImpl
 * Description:
 * date: 2021/12/12 下午10:34
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmploymentDao employmentDao;

    @Override
    @Cacheable(key = "#id", condition = "#id > 0", unless = "#result == null")
    public Employee getEmployeeById(int id) {
        return employmentDao.selectEmployeeById(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employmentDao.insertEmployee(employee);
    }

    @Override
    @CachePut(cacheNames = "emp", key="#employee.id")
    public Employee updateEmployee(Employee employee) {
        employmentDao.updateEmployee(employee);
        return employee;
    }

    @Override
    @CacheEvict(cacheNames = "emp", key = "#id", beforeInvocation = true)
    public int deleteEmployee(int id) {
        return employmentDao.deleteEmployee(id);
    }

}
