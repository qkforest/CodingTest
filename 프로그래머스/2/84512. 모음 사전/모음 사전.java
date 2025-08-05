import java.util.*;
class Solution {
    private final char[] alphabets = "AEIOU".toCharArray();
    private static List<String> dict = new ArrayList<>();
    private void generate(String temp, int len) {
        if(len == 5) {
            return;
        }
        for(int i = 0; i < 5; i++) {
            String next = temp + alphabets[i];
            dict.add(next);
            generate(next, len+1);
        }
    }
    public int solution(String word) {
        generate("", 0);
        return dict.indexOf(word)+1;
    }
}