import java.util.*;
class Solution {
    private static final Map<String, Integer> numbers = Map.of("zero" , 0, "one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        int len = 3;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                answer.append(s.charAt(i));
                i++;
            }
            else {
                if(numbers.containsKey(s.substring(i, i+len))) {
                    answer.append(numbers.get(s.substring(i, i+len)));
                    i += len;
                    len = 3;
                } else {
                    len++;
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }
}