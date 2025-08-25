import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int start = 0;
        int end = gems.length - 1;
        Set<String> gemSet = new HashSet<>(List.of(gems));
        Map<String, Integer> counts = new HashMap<>();
        int s = 0;
        int e = 0;
        counts.put(gems[s], 1);
                
        while(s < gems.length) {
            if(counts.keySet().size() == gemSet.size()) {
                if(e - s < end - start) {
                    end = e;
                    start = s;
                }
                if(counts.merge(gems[s], -1, Integer::sum) == 0) {
                    counts.remove(gems[s]);
                }
                s++;
            } else if(e < gems.length - 1) {
                counts.merge(gems[++e], 1, Integer::sum);
            } else {
                break;
            }
        }
        return new int[] {start+1, end+1};
    }
}