package com.anagram.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

import java.util.Set;

@Mapper
public interface AnagramMapper {

    @Select("select distinct value_sort from words")
    Cursor<String> scan();

    @Select("select value from words where value_sort = #{value_sort}")
    Set<String> findValueByValueSort(@Param("value_sort") String valueSort);
}