import java.util.*;

class Solution {
    private static int count;
    private static Set<String> answer;
    private static Set<Integer> comb;
    
    private void dfs(int level, String[] user_id, String[] banned_id) {
        if(level == count) {
            StringBuilder sb = new StringBuilder();
            for(int n : comb) {
                sb.append(n).append(" ");
            }
            answer.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(!comb.contains(i)) {
                if(user_id[i].length() == banned_id[level].length()) {
                    boolean flag = true;
                    for(int j = 0; j < user_id[i].length(); j++) {
                        if(banned_id[level].charAt(j) == '*' || banned_id[level].charAt(j) == user_id[i].charAt(j)) {
                            continue;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        comb.add(i);
                        dfs(level+1, user_id, banned_id);
                        comb.remove(i);
                    }
                }
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();
        count = banned_id.length;
        comb = new TreeSet<>();
        dfs(0, user_id, banned_id);
        return answer.size();
    }
}