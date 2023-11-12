import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        Map <Integer, Integer> temp = new TreeMap<>();
        for(int i = 0; i < attendance.length; i++){
            if(attendance[i])
                temp.put(rank[i], i);
        }
        answer = 10000 * (int) temp.values().toArray()[0] + 100 * (int) temp.values().toArray()[1] + (int) temp.values().toArray()[2]; 
        return answer;
    }
}