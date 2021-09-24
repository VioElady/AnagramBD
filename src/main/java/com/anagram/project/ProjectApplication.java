package com.anagram.project;

import com.anagram.project.model.Word;
import com.anagram.project.service.AnagramService;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes({Word.class})
@MapperScan("com.anagram.project.mapper")
@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

    @Autowired
    private AnagramService anagramService;

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        anagramService.findAnagrams();
    }
}
