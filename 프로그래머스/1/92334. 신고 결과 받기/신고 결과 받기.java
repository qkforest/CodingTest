import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set> map = new HashMap<>();
        Map<String, Integer> idx = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            idx.put(id_list[i], i);
        }
        
        for(String r : report) {
            String[] arr = r.split(" ");
            Set<String> list = map.getOrDefault(arr[1], new HashSet<>());
            list.add(arr[0]);
            map.put(arr[1], list);
        }
        
        for(String name : map.keySet()) {
            Set<String> list = map.get(name);
            if(list.size() >= k) {
                for(String n : list) {
                    answer[idx.get(n)]++;
                }
            }
        }
        
        return answer;
    }
}