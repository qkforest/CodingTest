import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> ans = new HashMap<>();
        for(String s : strArr){
            if(ans.containsKey(s.length()))
                ans.put(s.length(), ans.get(s.length())+1);
            else
                ans.put(s.length(), 1);
        }
        return Collections.max(ans.values());
    }
}