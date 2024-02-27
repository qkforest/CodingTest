import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer;
    static int[] map;
    public int solution(int n) {
        answer = 0;
        visited = new boolean[n];
        map = new int[n];
        dfs(0, n);
        return answer;
    }
    public void dfs(int level, int n){
        if(level == n){
            answer++;
            return;
        }else{
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    if(level > 0){
                        boolean cand = true;
                        for(int j = 1; j <= level; j++){
                            if(Math.abs(i - map[level - j]) == j){
                                cand = false;
                                break;
                            }    
                        }
                        if(!cand)
                            continue;
                    }
                    visited[i] = true;
                    map[level] = i;
                    dfs(level+1, n);
                    visited[i] = false;
                }
            }
        }
    }
}