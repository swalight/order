package cn.che001.order.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BaseMapper {
    @Select({"${sql}"})
    List<Map> _executeSelect(@Param("sql") String var1);

    @Select({"select count(1) from (${sql}) t"})
    Long _executeSelectCount(@Param("sql") String var1);

    @Insert({"${sql}"})
    Long _executeInsert(@Param("sql") String var1);

    @Update({"${sql}"})
    Long _executeUpdate(@Param("sql") String var1);

    @Delete({"${sql}"})
    Long _executeDelete(@Param("sql") String var1);
}