import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Set<Integer> r = new HashSet<>();
        boolean s;
        for(int i = 0; i < reserve.length; i++){
            r.add(reserve[i]);
        }
        for(int i = 0; i < lost.length; i++){
            if(r.contains(lost[i])){
                answer += 1;
                r.remove(lost[i]);
                lost[i] = -20;
            }
        }
        Arrays.sort(lost);
        for(int i = 0; i < lost.length; i++){
            s = true;
            if(lost[i] - 1 > 0 && r.contains(lost[i]-1)){
                answer += 1;
                r.remove(lost[i]-1);
                s = false;
            }
            if(s && lost[i] + 1 > 0 && lost[i] + 1 <= n && r.contains(lost[i]+1)){
                answer += 1;
                r.remove(lost[i]+1);
            }
        }
        return answer;
    }
}