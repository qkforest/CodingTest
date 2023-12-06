import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> c = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(c.containsKey(clothes[i][1]))
                c.put(clothes[i][1], c.get(clothes[i][1])+1);
            else
                c.put(clothes[i][1], 1);
        }
        
        for(int n : c.values())
            answer *= (n+1);
        return answer-1;
    }
}