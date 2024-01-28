import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> a = new HashMap<>();
        for(int n : topping){
            if(count.containsKey(n))
                count.put(n, count.get(n)+1);
            else
                count.put(n, 1);
        }
        for(int n : topping){
            count.put(n, count.get(n)-1);
            if(count.get(n) == 0)
                count.remove(n);
            if(a.containsKey(n))
                a.put(n, a.get(n)+1);
            else
                a.put(n, 1);
            if(count.size() == a.size())
                answer++;
        }
        return answer;
    }
}