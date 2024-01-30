import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        s.add(y);
        while(!s.isEmpty()){
            if(s.contains(x)) return answer;
            Set<Integer> s2 = new HashSet<>();
            for(int num : s){
                if(num - n >= x) s2.add(num-n);
                if(num % 2 == 0) s2.add(num/2);
                if(num % 3 == 0) s2.add(num/3);
            }
            s = s2;
            answer += 1;
        }
        return -1;
    }
}