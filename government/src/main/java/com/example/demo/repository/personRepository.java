package com.example.demo.repository;
import com.example.demo.domain.person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;


import java.util.List;

@Mapper
public interface personRepository {
    @Results(id = "personMap", value = {
            @Result(property = "ID", column = "ID", jdbcType = JdbcType.INTEGER),
            @Result(property = "P_name", column = "P_name"),
            @Result(property = "P_account", column = "P_account"),
            @Result(property = "P_password", column = "P_password"),
            @Result(property = "type", column = "type")
    })
    @Select("select * from person")
    public List<person> findAll();

    @Select("select * from person where P_account=#{account} and P_password=md5(#{password})")
    @ResultMap(value = "personMap")
    public person validperson(@Param("account") String account, @Param("password") String password);

    @Select("select * from person where P_account like concat('%',#{P_account},'%')")
    @ResultMap(value = "personMap")
    public List<person> findByName(@Param("P_account") String P_account);

    @Insert("insert into person (P_name,P_account,P_password,type) values( #{name},#{account},md5(#{p1}),#{type})")
    @ResultMap(value = "personMap")
    public void addthem(@Param("name")String add_name,@Param("account")String add_account,@Param("p1")String p1,@Param("type")int type);

    @Update("update person set P_password=md5(#{password}) where P_name=#{name}")
    @ResultMap(value="personMap")
    public void updateit(@Param("password") String password,@Param("name") String name);
}

