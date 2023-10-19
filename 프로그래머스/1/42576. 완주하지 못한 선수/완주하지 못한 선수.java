import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> p = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++){
            if(p.containsKey(participant[i]))
                p.put(participant[i], p.get(participant[i])+1);
            else
                p.put(participant[i], 1);
        }

        for (String c : completion){
            if(!(p.containsKey(c)))
                answer = c;
            else {
                if(p.containsKey(c))
                    p.put(c, p.get(c)-1);
            } 
        }
        
        if(answer.equals("")){
            for(String n :p.keySet()){
                if(p.get(n) == 1){
                    answer = n;
                    break;
                }
            }
        }
            
        return answer;
    }
}