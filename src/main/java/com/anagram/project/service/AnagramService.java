package com.anagram.project.service;

import com.anagram.project.mapper.AnagramMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Log4j2
@Service
public class AnagramService {

    @Autowired
    private AnagramMapper anagramMapper;

    @Transactional
    public void findAnagrams() {
        anagramMapper.scan().forEach(this::viewData);
    }

    private void viewData(String word) {
        Set<String> anagrams = anagramMapper.findValueByValueSort(word);

        if (anagrams.size() >= 2) {
            log.info("Anagrams: {}", anagrams);
        }
    }
}






