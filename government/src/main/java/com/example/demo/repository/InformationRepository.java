package com.example.demo.repository;

import com.example.demo.domain.Information;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface InformationRepository {
    @Results(id="InformationMap", value={
            @Result(property = "user_id", column = "user_id",  jdbcType= JdbcType.INTEGER),
            @Result(property = "user_name", column = "user_name"),
            @Result(property = "phone" , column = "phone"),
            @Result(property = "job" , column = "job"),
            @Result(property = "kind", column = "kind")
    })
    @Select("select * from infromation")
    public List<Information> findAll();


    @Select("select * from infromation where user_name=#{name} ")
    @ResultMap(value="InformationMap")
    public Information validInformation(@Param("name") String account);

    @Select("select * from infromation where user_name like concat('%',#{name},'%')")
    @ResultMap(value="InformationMap")
    public List<Information> findByName(@Param("name") String name);

        @Select("select * from infromation where kind = #{kind}")
    @ResultMap(value = "InformationMap")
    public List<Information> findByKind(@Param("kind")String kind);



//    @Results(id="UserMap", value={
//            @Result(property = "user_id", column = "user_id",  jdbcType=JdbcType.INTEGER),
//            @Result(property = "user_account", column = "user_account"),
//            @Result(property = "user_name", column = "user_name")
//    })
//
//    @Select("select * from user")
//    public List<User> findAll();
//
//    @Select("select * from user where user_account=#{account} and user_password=md5(#{password})")
//    @ResultMap(value="UserMap")
//    public User validTeacher(@Param("account") String account, @Param("password") String password);
//
//    @Select("select * from user where user_name like concat('%',#{name},'%')")
//    @ResultMap(value="UserMap")
//    public List<User> findByName(@Param("name") String name);


}
