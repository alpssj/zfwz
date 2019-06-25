package com.example.demo.repository;

import com.example.demo.domain.Policy;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface PolicyRepository {
    @Results(id="PolicyMap", value={
            @Result(property = "policy_id", column = "policy_id",  jdbcType= JdbcType.INTEGER),
            @Result(property = "policy_name", column = "policy_name"),
            @Result(property = "policy_link" , column = "policy_link"),
            @Result(property = "department" , column = "department")
    })
    @Select("select * from policy")
    public List<Policy> findAll();
    @Select("select * from policy where department=#{department} ")
    @ResultMap(value="PolicyMap")
    public List<Policy> validPolicy(@Param("department") String department);

    @Select("select * from policy where department like concat('%',#{department},'%')")
    @ResultMap(value="PolicyMap")
    public List<Policy> findByName(@Param("department") String department);

    @Delete("delete from policy where policy_name=#{GenName}")
    @ResultMap(value="PolicyMap")
    public int deletePolicy(@Param("GenName") String GenName);

    @Insert("INSERT INTO policy ( policy_name, policy_link,department) VALUES (#{fileName}, #{fileLink}, #{fileDepartment})")
    public int savePolicy(@Param("fileName") String fileName,@Param("fileLink") String fileLink,@Param("fileDepartment") String fileDepartment);

}
