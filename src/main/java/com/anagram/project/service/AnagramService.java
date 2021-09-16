package com.anagram.project.service;

import com.anagram.project.mapper.WordMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Data
public class AnagramService {

    private WordMapper wordMapper;

    private static String canonicalize(String s) {
        return Stream.of(s.split("")).sorted().collect(Collectors.joining());
    }

    public static List<Set<String>> getAnagrams(List<String> lists) {
        Map<String, Set<String>> map = lists.stream()
                .flatMap(Pattern.compile("\\W+")::splitAsStream)
                .collect(Collectors.groupingBy(AnagramService::canonicalize, Collectors.toSet()));
        return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
    }
}
