import java.util.*;
class Solution {
    public boolean isNumber(char c){
        try{
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public int solution(String s) {
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String answer = "";
        String temp = "";
        for(char c : s.toCharArray()){
            if(isNumber(c))
                answer += c - '0';
            else
                temp += c;
            if(Arrays.asList(word).contains(temp)){
                answer += Arrays.asList(word).indexOf(temp);
                temp = "";
            }
        }
        return Integer.parseInt(answer);
    }
}