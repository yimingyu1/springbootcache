package cn.mingyu.springbootcache.dao;

import cn.mingyu.springbootcache.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: EmploymentDao
 * Description:
 * date: 2021/12/12 下午10:16
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */

public interface EmploymentDao {

    @Select("select * from employee where id = #{id}")
    Employee selectEmployeeById(@Param("id") Integer id);

    @Insert("insert into employee(last_name, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{dId})")
    int insertEmployee(Employee employee);

    @Update("update employee set last_name = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    int updateEmployee(Employee employee);

    @Delete("delete from employee where id = #{id}")
    int deleteEmployee(@Param("id") Integer id);

}
