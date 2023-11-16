import java.util.*;
class Solution {
    public int solution(int n) {
        Set<Integer> d = new HashSet<>(); 
        for(int i = 1; i <= n; i++){
            if(!d.contains(i) && n % i == 0){
                d.add(i);
            }
        }
        return d.size();
    }
}