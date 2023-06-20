package Beispiele;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main(String[] args) {
        List<String> TestListe =  Arrays.asList("Hallo","Das","ist","ein","Test","Duda","Hallo");

        TestListe.stream()
            .sorted(Comparator.comparingInt(String::length))
            .forEach(n-> System.out.println(n + ": " + n.length()));

//        new Random() .ints()
//                .map( n -> Math.abs(n)%1000 )
//                .peek( System.out::println )
//                .anyMatch(n -> 10 <= n && n < 20);

        Set<String> wordSet = TestListe.stream().collect(Collectors.toSet());
        wordSet.stream()
                .sorted(Comparator.comparingInt(String::length)
                .reversed())
                .forEach(n-> System.out.println(n + ": " + n.length()));
    }

}
