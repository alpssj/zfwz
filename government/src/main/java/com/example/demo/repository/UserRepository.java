package com.example.demo.repository;


import com.example.demo.domain.User;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import java.util.List;

@Mapper
public interface UserRepository {

	@Results(id="UserMap", value={
    @Result(property = "user_id", column = "user_id",  jdbcType=JdbcType.INTEGER),
    @Result(property = "user_account", column = "user_account"),
    @Result(property = "user_name", column = "user_name")
	})

	@Select("select * from user")
	public List<User> findAll();

	@Select("select * from user where user_account=#{account} and user_password=md5(#{password})")
	@ResultMap(value="UserMap")
	public User validTeacher(@Param("account") String account, @Param("password") String password);

	@Select("select * from user where user_name like concat('%',#{name},'%')")
	@ResultMap(value="UserMap")
	public List<User> findByName(@Param("name") String name);
	
}