package com.example.demo.repository;

import com.example.demo.domain.Information;
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

}
