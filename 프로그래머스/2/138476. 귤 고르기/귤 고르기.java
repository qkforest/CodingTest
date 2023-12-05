import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            if(count.containsKey(tangerine[i]))
                count.put(tangerine[i], count.get(tangerine[i])+1);
            else
                count.put(tangerine[i], 1);  
        }
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(count.entrySet());
        entryList.sort(((o1, o2) -> count.get(o2.getKey()) - count.get(o1.getKey())));
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(k <= 0)
                break;
            k -= entry.getValue();
            answer++;
        }
        return answer;
    }
}