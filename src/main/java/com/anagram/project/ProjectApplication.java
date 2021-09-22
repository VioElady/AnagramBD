
package com.anagram.project;

import com.anagram.project.model.Word;
import com.anagram.project.service.AnagramService;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

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
        List<Set<String>> anagrams = anagramService.findAnagrams();
        System.out.println(anagrams);
    }
}

//
//    Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//
//        AnagramsMapper mapper = session.getMapper(AnagramsMapper.class);
//        mapper.createFunction();
//        mapper.createTable();
//        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\andrei.lisa\\IdeaProjects\\qwe\\folder\\"))) {
//            List<String> result = walk.filter(Files::isRegularFile)
//                    .map(Path::toString)
//                    .filter(s -> s.endsWith(".txt")).collect(Collectors.toList());
//            for (int i = 0; i < result.size(); i++)
//                mapper.write(result.get(i));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        AnagramsMapper anagramsMapper = session.getMapper(AnagramsMapper.class);
//        Cursor<String> anagrams = anagramsMapper.showAll();
//        for (String anagram : anagrams) {
//            TreeSet<String> anagramsByValue = anagramsMapper.anagrams(anagram);
//            if (anagramsByValue.size() > 1) {
//                System.out.println(anagramsByValue.toString().replaceAll("\\[", " ")
//                        .replaceAll(",", " ")
//                        .replaceAll("]", " ").replaceAll("\\{", " ")
//                        .replaceAll("\\}", " "));
//
//            }


