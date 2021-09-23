package com.anagram.project.service;

import com.anagram.project.mapper.AnagramMapper;
import com.anagram.project.model.Word;
import com.anagram.project.util.AnagramUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class AnagramService {

    @Autowired
    private AnagramMapper anagramMapper;

    @Transactional
    public List<Set<String>> findAnagrams() {
        AtomicInteger i = new AtomicInteger(5);
//        anagramMapper.scan().forEach(v ->
//        {
//
//            System.out.println(i.incrementAndGet());
//        });

        List<String> values =
                anagramMapper.findAll().stream()
                        .map(Word::getValue)
                        .distinct()
                        .collect(Collectors.toList());

        return AnagramUtil.anagrams(values);
    }

}

