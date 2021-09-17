package com.anagram.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Anagram {
    private Long id;
    private String value;

    public String getValue() {
        return value;
    }

}
