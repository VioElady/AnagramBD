package com.anagram.project.controller;

import com.anagram.project.mapper.WordMapper;
import com.anagram.project.model.Word;
import com.anagram.project.service.AnagramService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Api
@RestController
@RequestMapping("/api/v1")
public class WordController {

    @Autowired
    private WordMapper wordMapper;
    private InputStreamReader inputStreamReader;

    @GetMapping("/all/anagrams")
    private List<Set<String>> findAllAnagrams() {
        List<Word> words = wordMapper.findAll();
        List<String> values = words.stream().map(Word::getValue).collect(Collectors.toList());
        return AnagramService.getAnagrams(values);
    }
}


