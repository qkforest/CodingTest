import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        String temp = "";
        Map<String, Integer> rank = new HashMap<>();
        int idx;
        for(int i = 0; i < players.length; i++){
            rank.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++){
            idx = rank.get(callings[i]);
            rank.put(callings[i], idx-1);  
            temp = answer[idx-1];
            rank.put(temp, idx);  
            answer[idx-1] = callings[i];
            answer[idx] = temp;
        }
        return answer;
    }
}