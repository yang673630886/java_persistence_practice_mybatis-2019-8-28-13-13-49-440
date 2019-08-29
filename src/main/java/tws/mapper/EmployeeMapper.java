package tws.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.Employee;

@Mapper
public interface EmployeeMapper {

	@Insert("insert into employee(id,name,age) values(#{employee.id}, #{employee.name}, #{employee.age})")
	public void createEmployee(@Param("employee") Employee employee);

	@Select("select * from employee")
	public List<Employee> selectEmployees();
	
	@Select("select * from employee where id = #{id}")
	public Employee selectOneEmployee(@Param("id") int id);
	
	@Delete("delete from employee where id = #{id}")
	public void deleteEmployee(@Param("id") int id);
	
	@Update("update employee set name = #{employee.name},age=#{employee.age} where id = #{id}")
	public void updateEmployee(@Param("id") int id,@Param("employee") Employee employee);
}
