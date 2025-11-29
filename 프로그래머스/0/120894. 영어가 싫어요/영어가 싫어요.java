import java.util.*;
class Solution {
    public long solution(String numbers) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String temp = "", word = "";
        for(char c: numbers.toCharArray()){
            word += c;
            if(Arrays.asList(num).contains(word)){
                temp += String.valueOf(Arrays.asList(num).indexOf(word));
                word = "";
            }
        }
        return Long.parseLong(temp);
    }
}