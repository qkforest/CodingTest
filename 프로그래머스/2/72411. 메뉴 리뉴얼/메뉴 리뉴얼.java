import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        int end = course.length-1;
        Map<Integer, Integer> lens = new TreeMap<>(Collections.reverseOrder());
        for(String order : orders){
            int l = order.length();
            if(lens.containsKey(l)) lens.put(l, lens.get(l)+1);
            else lens.put(l, 1);
        }
        for(int i = end; i >= 0; i--){
            int count = 0;
            boolean escape = false;
            for(int l : lens.keySet()){
                if(count > 1){
                    escape = true;
                    end = i;
                    break;
                }
                if(l >= course[i]) count += lens.get(l);
            }
            if(escape) break;
        }
        for(int i = 0; i <= end; i++){
            Map<String, Integer> counts = new HashMap<>();
            for(String order : orders){
                 if(order.length() >= course[i]) {
                     char[] o = order.toCharArray();
                     boolean[] visited = new boolean[o.length];
                     dfs(course[i], 0, 0, o, visited, counts);
                 }
            }
            if(!counts.isEmpty()){
                List<String> keys = new ArrayList<>(counts.keySet());
                Collections.sort(keys, (v1, v2) -> (counts.get(v2).compareTo(counts.get(v1))));
                int max = counts.get(keys.get(0));
                if(max < 2) break;
                for(String k : keys){
                    if(max > counts.get(k)) break;
                    answer.add(k);
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    public void dfs(int length, int level, int start, char[] o, boolean[] visited, Map<String, Integer> counts){
        if(level == length){
            String temp = "";
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) temp += o[i];
            }
            char[] charArr = temp.toCharArray();
            Arrays.sort(charArr);
            String result = new String(charArr);
            if(counts.containsKey(result)) counts.put(result, counts.get(result)+1);
            else counts.put(result, 1);
        }else{
            for(int i = start; i < o.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(length, level+1, i+1, o, visited, counts);
                    visited[i] = false;
                }
            }
        }
    }
}