import java.util.*;

class Solution {
    private List<String> answer;
    private Map<String, Integer> map;
    private int max;
    private void dfs(String order, int c, int start, int level, StringBuilder sb) {
        if(level == c) {
            int count = 1;
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr); 
            String s = new String(arr); 
            if(map.containsKey(s)) {
                count = map.get(s) + 1;
            }
            map.put(s, count);
            max = Math.max(count, max);
            return;
        }
        for(int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(order, c, i+1, level+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        answer = new ArrayList<>();
        for(int c : course) {
            max = 0;
            map = new HashMap<>();
            for(String order : orders) {
                dfs(order, c, 0, 0, new StringBuilder());
            }
            if(max == 1) {
                continue;
            }
            for(String o : map.keySet()) {
                if(map.get(o) == max) {
                    answer.add(o);
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}