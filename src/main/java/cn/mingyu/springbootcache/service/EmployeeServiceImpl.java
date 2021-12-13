package cn.mingyu.springbootcache.service;

import cn.mingyu.springbootcache.dao.EmploymentDao;
import cn.mingyu.springbootcache.entity.Employee;
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
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmploymentDao employmentDao;

    @Override
    @Cacheable(cacheNames = "emp", key = "#id", condition = "#id > 0", unless = "#result == null")
    public Employee getEmployeeById(int id) {
        return employmentDao.selectEmployeeById(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employmentDao.insertEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employmentDao.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employmentDao.deleteEmployee(id);
    }
}
