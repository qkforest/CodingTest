import java.util.*;
class Solution {
    public boolean isInteger(String s) {
        try{
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public int[] solution(String my_string) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < my_string.length(); i++){
            if(isInteger(my_string.substring(i, i+1))){
                answer.add(Integer.parseInt(my_string.substring(i, i+1)));
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}