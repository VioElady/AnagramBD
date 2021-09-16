package com.anagram.project.mapper;

import com.anagram.project.model.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface WordMapper {

    @Select("select value,id as Id from words")
    List<Word> findAll();

//                  @Select("select * from foo value #{value}")
//                   Cursor<Word> scan(@Param("value") int limit);

}

