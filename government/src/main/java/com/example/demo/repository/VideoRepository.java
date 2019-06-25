package com.example.demo.repository;

import com.example.demo.domain.Video;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface VideoRepository {
    @Results(id="VideoMap", value={
            @Result(property = "video_id", column = "video_id",  jdbcType= JdbcType.INTEGER),
            @Result(property = "video_name", column = "video_name"),
            @Result(property = "video_link" , column = "video_link"),
            @Result(property = "video_kind" , column = "video_kind"),

    })
    @Select("select * from video")
    public List<Video> findAll();

    @Insert("INSERT INTO video (video_name, video_link,video_kind) VALUES (#{videoName}, #{videoLink}, #{videoKind})")
    public int saveVideo(@Param("videoName") String videoName,@Param("videoLink") String videoLink,@Param("videoKind") String videoKind);

    @Delete("delete from video where video_name=#{VioName}")
    @ResultMap(value="VideoMap")
    public int deleteVideo(@Param("VioName") String VioName);
//
//    @Delete("delete from policy where policy_name=#{GenName}")
//    @ResultMap(value="PolicyMap")
//    public int deletePolicy(@Param("GenName") String GenName);

}
