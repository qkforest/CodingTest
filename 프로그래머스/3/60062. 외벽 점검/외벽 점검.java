import java.util.*;
class Solution {
    static int answer, len;
    static int[] Weak;
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        len = weak.length;
        Weak = new int[2*len];
        int idx = 0;
        while(idx < len){
            Weak[idx] = weak[idx];
            Weak[len+idx] = weak[idx++]+n;
        }
        for(int i = 0; i < len; i++)
            dfs(i, 0, dist, new boolean[dist.length], new int[dist.length]);
        if(answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }
    public void dfs(int start, int level, int[] dist, boolean[] visited, int[] per){
        if(level == dist.length){
            answer = Math.min(answer, check(start, start+len, per));
            return;
        }
        for(int i = 0; i < dist.length; i++){
            if(!visited[i]){
                visited[i] = true;
                per[level] = dist[i];
                dfs(start, level+1, dist, visited, per);
                visited[i] = false;
            }
        }
    }
    public int check(int start, int end, int[] per){
        int count = 1;
        int pos = Weak[start] + per[count-1];
        for(int i = start; i < end ;i++){
            if(pos < Weak[i]){
                count++;
                if(count > per.length) return Integer.MAX_VALUE;
                pos = Weak[i] + per[count-1];
            }
        }
        return count;
    }
}