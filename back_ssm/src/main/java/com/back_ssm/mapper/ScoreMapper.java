package com.back_ssm.mapper;

import com.back_ssm.pojo.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ScoreMapper {
    @Insert("insert into sc values(#{sno},#{cno},#{sscore})")
    public int addScore(Score score);
    @Delete("delete from sc where sno=#{sno} and cno=#{cno}")
    public int delScore(Score score);
    @Update("update sc set sscore=#{sscore} where sno=#{sno} and cno=#{cno}")
    public int altScore(Score score);
    @Select("select * from sc where sno=#{sno} and cno=#{cno}")
    public Score findScore(Score score);
}
