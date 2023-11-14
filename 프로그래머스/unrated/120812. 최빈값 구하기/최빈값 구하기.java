import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int n : array){
            if(m.containsKey(n))
                m.put(n, m.get(n)+1);
            else
                m.put(n, 1);
        }
        answer = Collections.max(m.values());
        if(Collections.frequency(m.values(), answer) > 1)
            answer = -1;
        else{
            for(Map.Entry<Integer, Integer> entry : m.entrySet()){
                if(entry.getValue().equals(answer)){
                    answer = entry.getKey();
                    break;
                }
            }   
        }
        return answer;
    }
}