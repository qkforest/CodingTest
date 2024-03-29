import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        int len = food_times.length;
        List<int[]> foods = new ArrayList<>();
        for(int i = 0; i < len; i++)
            foods.add(new int[]{food_times[i], i+1});
        Collections.sort(foods, (a, b) -> a[0] - b[0]);
        int i = 0;
        for(; i < len; i++) {
            int t = (i == 0) ? foods.get(i)[0] : foods.get(i)[0] - foods.get(i - 1)[0];
            if(k < (long) t * (len - i)) 
                break;
            k -= (long) t * (len - i);
        }
        if(i == len) return -1;
        foods.subList(i, len).sort((a, b) -> a[1] - b[1]);
        return foods.get((int) (i + k % (len - i)))[1];
    }
}