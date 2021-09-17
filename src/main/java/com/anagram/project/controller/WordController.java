package com.anagram.project.controller;

import com.anagram.project.mapper.WordMapper;
import com.anagram.project.model.Anagram;
import com.anagram.project.service.AnagramService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@Api
@RestController
@RequestMapping("/api/v1")
public class WordController {

    @Autowired
    private WordMapper wordMapper;

    @GetMapping("/all/anagrams")
    private List<Set<String>> findAllAnagrams() {
        List<Anagram> anagrams = wordMapper.findAll();
        List<String> values = anagrams.stream().map(Anagram::getValue).collect(Collectors.toList());
        return AnagramService.getAnagrams(values);
       // return anagrams;
    }

    @GetMapping("/test")
    public List<Anagram> testConnection() {
        return wordMapper.testConnection();
    }

}


