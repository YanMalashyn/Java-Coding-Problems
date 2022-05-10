package Chapter01.P01;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class p01 {
    public static void main(String[] args) {
        String s = "Hello world";
        Map<Character, Integer> characterIntegerMap = countDuplicateChar(s);
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            System.out.println(entry);
        }
        Map<Character, Long> characterLongMap = countDuplicateCharByStream(s);
        System.out.println("_____________");
        for (Map.Entry<Character, Long> entry : characterLongMap.entrySet()) {
            System.out.println(entry);
        }
    }


    public static Map<Character, Integer> countDuplicateChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.merge(aChar, 1, Integer::sum);
        }
        return map;
    }

    public static Map<Character, Long> countDuplicateCharByStream(String s) {
       return s.chars()
               .mapToObj(c -> (char) c)
               .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}


