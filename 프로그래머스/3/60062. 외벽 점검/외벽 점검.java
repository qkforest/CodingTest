import java.util.*;
class Solution {
    static int answer, len;
    static int[] Weak;
    public int solution(int n, int[] weak, int[] dist) {
        len = weak.length;
        answer = Integer.MAX_VALUE;
        Weak = new int[len*2];
        int idx = 0;
        while(idx < len){
            Weak[idx] = weak[idx];
            Weak[idx+len] = weak[idx++] + n;
        }
        for(int i = 0; i < len; i++)
            dfs(i, 0, dist, new boolean[dist.length], new int[dist.length]);
        if(answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }
    public void dfs(int s, int level, int[] dist, boolean[] visited, int[] permuted){
        if(level == dist.length){
            answer = Math.min(answer, check(s, s+len, permuted));
            return;
        } 
        for(int i = 0; i < dist.length; i++){
            if(!visited[i]){
                visited[i] = true;
                permuted[level] = dist[i];
                dfs(s, level+1, dist, visited, permuted);
                visited[i] = false;
            }
        }
    }
    public int check(int s, int e, int[] permuted){
        int count = 1;
        int pos = Weak[s]+permuted[count-1];
        for(int i = s; i < e; i++){
            if(pos < Weak[i]){
                count++;
                if(count > permuted.length) return Integer.MAX_VALUE;
                pos = Weak[i] + permuted[count-1];
            }
        }
        return count;
    }
}