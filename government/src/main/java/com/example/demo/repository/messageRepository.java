package com.example.demo.repository;

import com.example.demo.domain.message;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
@Mapper
public interface messageRepository {
    @Results(id="messageMap", value={
            @Result(property = "ID", column = "ID",  jdbcType= JdbcType.INTEGER),
            @Result(property = "name", column = "name"),
            @Result(property = "mess" , column = "mess")
    })
    @Select("select * from message")
    public List<message> findAll();


    @Select("select * from message where name=#{name} ")
    @ResultMap(value="messageMap")
    public message validmessage(@Param("name") String Information);


    @Select("select * from message where name like concat('%',#{name},'%')")
    @ResultMap(value="messageMap")
    public List<message> findByName(@Param("name") String name);

    @Delete("delete  from message where ID=#{ID}")
    @ResultMap(value="messageMap")
    public int deleteit(@Param("ID") int ID);

    @Insert("insert into message (name,mes) values(#{name},#{mess}")
    @ResultMap(value="messageMap")
    public void insertit(@Param("name") String name,@Param("mess") String mess);



}
