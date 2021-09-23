
package com.anagram.project.mapper;

import com.anagram.project.model.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

@Mapper
public interface AnagramMapper {

    @Select("select id,value from words")
    List<Word> findAll();

    @Select("select id,value from words")
    Cursor<Word> scan();

}

