import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] rep = new int[id_list.length];
        String[] rep2 = new String[id_list.length];
        int[] answer = new int[id_list.length];
        Set<String> temp = new HashSet<>(Arrays.asList(report));
        for(String s : temp){
            String[] t = s.split(" ");
            int idx = Arrays.asList(id_list).indexOf(t[1]);
            rep2[idx] = rep2[idx] + t[0] + ",";
            rep[idx] += 1;
        }
        for(int i = 0; i < answer.length; i++){
            if(rep[i] >= k){
                for(String s : rep2[i].replaceAll("null","").split(","))
                    answer[Arrays.asList(id_list).indexOf(s)] += 1;
            }
        }
        return answer;
    }
}