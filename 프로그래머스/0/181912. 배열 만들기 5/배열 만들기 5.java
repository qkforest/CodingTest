import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < intStrs.length; i++){
            if(Integer.valueOf(intStrs[i].substring(s, s+l)) > k)
                answer.add(Integer.valueOf(intStrs[i].substring(s, s+l)));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}