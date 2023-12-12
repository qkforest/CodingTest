import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int idx = 27;
        String w = "";
        char c;
        Map<String, Integer> newD = new HashMap<>();
        for(int i = 0; i < msg.length(); i++){
            w += msg.charAt(i);
            if(i < msg.length()-1)
                c = msg.charAt(i+1);
            else
                c = 0;
            if(newD.containsKey(w+c))
                continue;
            else {
                newD.put(w+c, idx);
                idx++;
                if(w.length() == 1){
                    answer.add(w.charAt(0) - 'A' + 1);
                    w = "";
                }
                 else if(newD.containsKey(w)){
                    answer.add(newD.get(w));
                    w = "";
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}