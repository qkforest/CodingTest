import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> category = new HashSet<>();
        Map<String, Integer> counts = new HashMap<>();
        for(int i = 0; i < gems.length; i++) category.add(gems[i]);
        if(category.size() == 1) return new int[] {1, 1};
        int end = 0, start = 0;
        for(int i = 0; i < gems.length; i++){
            if(counts.size() != category.size()){
                if(!counts.containsKey(gems[i])) {
                    counts.put(gems[i], 1);
                    end = i;
                } else counts.put(gems[i], counts.get(gems[i])+1);
            } else break;
        }
        int dis = end - start + 1;
        answer[0] = start+1;
        answer[1] = end+1;
        for(int i = end; i < gems.length; i++){
            while(i - start + 1 >= category.size()){
                if(counts.get(gems[start]) >= 2) {
                    counts.put(gems[start], counts.get(gems[start])-1);
                    start++;
                } else break;
            }
            if(i - start + 1 < dis){
                dis = i - start + 1;
                answer[0] = start+1;
                answer[1] = i+1;
            }
            if(i < gems.length - 1) counts.put(gems[i+1], counts.get(gems[i+1])+1);
        }
        return answer;
    }
}