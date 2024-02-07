import java.util.*;
class Solution {
    public static boolean[] visited;
    public static int count;
    public static Set<String> duplicated;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        count = banned_id.length;
        duplicated = new HashSet<>();
        dfs(0, user_id, banned_id);
        return duplicated.size();
    }
    public void dfs(int level, String[] user_id, String[] banned_id){
        if(level == count){
            int[] temp = new int[count];
            int idx = 0;
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    temp[idx] = i;
                    idx++;
                }
            }
            duplicated.add(Arrays.toString(temp));
        } else{
            for(int i = 0; i < visited.length; i++){
                if(!visited[i]){
                    if(check(user_id[i], banned_id[level])){
                        visited[i] = true;
                        dfs(level+1, user_id, banned_id);
                        visited[i] = false;
                    }
                }
            }
        } 
    }
    public boolean check(String user_id, String banned_id){
        if(user_id.length() != banned_id.length()) return false;
        for(int i = 0; i < user_id.length(); i++){
            if(banned_id.charAt(i) == '*') continue;
            else{
                if(user_id.charAt(i) != banned_id.charAt(i)) return false;
            }
        }
        return true;
    }
}