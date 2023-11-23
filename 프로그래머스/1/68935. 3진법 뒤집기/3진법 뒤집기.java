import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> r3 = new ArrayList<>();
        while(n!=0){
            r3.add(n%3);
            n /= 3;
        }
        String ans = "";
        for(int i = 0; i < r3.size(); i++){
            ans += r3.get(i);
        }
        return Integer.parseInt(ans, 3);
    }
}