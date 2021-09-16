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

@Api
@RestController
@RequestMapping("/api/v1")
public class WordController {

    @Autowired
    private WordMapper wordMapper;
    private InputStreamReader inputStreamReader;

    @GetMapping("/all/anagrams")
    private HashMap<String, List<List<Set<String>>>> findAllAnagrams() {
        List<Word> words =  wordMapper.scan();
        HashMap<String, List<List<Set<String>>>> map = new HashMap<>();
        List<String> finalAnagrams = new ArrayList<>();
        for (Word w3 : words) {
            finalAnagrams.add(w3.getValue());
        }
        for (Word w1 : words) {
            List<List<Set<String>>> outputs = new ArrayList<>();
            for (Word w2 : words) {
                List<Set<String>> output = AnagramService.getAnagrams((ArrayList<String>) finalAnagrams);
                if (output != null)
                    outputs.add(output);
            }
            map.put(w1.getValue(), outputs);
        }


        return map;
    }
}

//
//    public class Anagrams {
//        private static String canonicalize(String s) {
//            return Stream.of(s.split("")).sorted().collect(Collectors.joining());
//        }
//        public static List<Set<String>> getAnagrams(Reader reader) {
//            Map<String, Set<String>> map = new BufferedReader(reader).lines()
//                    .flatMap(Pattern.compile("\\W+")::splitAsStream)
//                    .collect(Collectors.groupingBy(Anagrams::canonicalize, Collectors.toSet()));
//            return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
//        }
//
//        public static void main(String[] args) throws IOException {
//            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("D:\\anagram\\external-sort.txt"));
//            getAnagrams(inputStreamReader).forEach(System.out::println);
//
//        }
//    }


