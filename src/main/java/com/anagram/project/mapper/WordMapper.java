package com.anagram.project.mapper;

import com.anagram.project.model.Anagram;
import com.anagram.project.model.Anagram;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface WordMapper {

    @Select("select id,value from words")
    List<Anagram> findAll();

    @Select("select id, value from words")
    List<Anagram> testConnection();

  //   @Select("select * from foo value #{value}")
  //   Cursor<Word> scan(@Param("value") int limit);

}

