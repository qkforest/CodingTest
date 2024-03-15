import java.util.*;
class Solution {
    static Map<String, List<Integer>> comb = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i = 0; i < info.length; i++)
            dfs(0, "", info[i].split(" "));
        
        for(List<Integer> score : comb.values())
            Collections.sort(score);
        
        for(int i = 0; i < query.length; i++){
            String[] q = query[i].split(" and ");
            String[] sp = q[3].split(" ");
            q[3] = sp[0];
            String key = String.join("", q);
            int score = Integer.parseInt(sp[1]);
            if(comb.containsKey(key)){
                List<Integer> temp = comb.get(key);
                int start = 0;
                int end = temp.size() - 1;
                while(start <= end){
                    int mid = (start + end) / 2;
                    if(temp.get(mid) < score)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
                answer[i] = temp.size() - start;
            }
        }
        return answer;
    }
    public void dfs(int idx, String s, String[] arr){
        if(idx == 4){
            comb.computeIfAbsent(s, key -> new ArrayList<>()).add(Integer.parseInt(arr[4]));
            return;
        }
        dfs(idx+1, s+arr[idx], arr);
        dfs(idx+1, s+"-", arr);
    }
}