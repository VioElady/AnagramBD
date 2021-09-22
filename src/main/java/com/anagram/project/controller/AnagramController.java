package com.anagram.project.controller;

import com.anagram.project.service.AnagramService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Api
@RestController
@RequestMapping("anagram")
public class AnagramController {

    @Autowired
    private AnagramService anagramService;

    @GetMapping
    private List<Set<String>> findAnagrams() {
        return anagramService.findAnagrams();
    }


}

