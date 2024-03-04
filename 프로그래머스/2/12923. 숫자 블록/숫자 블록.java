import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end-begin)+1;
        int[] answer = new int[len];
        int idx = 0;
        for(long i = begin; i <= end; i++)
            answer[idx++] = maxFactor(i);
        return answer;
    }
    public int maxFactor(long n){
        if(n == 1)
            return 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                list.add(i);
                if(n/i <= 10000000)
                    return (int)(n/i);
            }
        }
        if(!list.isEmpty())
            return list.get(list.size() - 1);
        return 1;
    }
}