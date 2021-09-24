package com.anagram.project.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Word implements Serializable {
    private Long id;
    private String value;
    private String valueSort;
}