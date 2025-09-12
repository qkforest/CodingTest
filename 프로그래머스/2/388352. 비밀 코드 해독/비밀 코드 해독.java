import java.util.*;

class Solution {
    private static int answer, m;
    private static int[] comb = new int[5];
    private static Set<Integer>[] arr;
    
    private static void dfs(int level, int start, int n, int[] ans) {
        if(level == 5) {
            boolean same = true;
            
            for(int i = 0; i < m; i++) {
                int count = 0;
                for(int j = 0; j < 5; j++) {
                    if(arr[i].contains(comb[j])) {
                        count++;
                    }
                }
                if(count != ans[i]) {
                    same = false;
                    break;
                } 
            }
            
            if(same) {
                answer++;
            }
            
            return;
        }
        
        for(int i = start; i <= n; i++) {
            comb[level] = i;
            dfs(level+1, i+1, n, ans);
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        m = q.length;
        arr = new HashSet[m];
        
        for(int i = 0; i < m; i++) {
            arr[i] = new HashSet<>();
            for(int j = 0; j < 5; j++) {
                arr[i].add(q[i][j]);
            }
        }
        
        dfs(0, 1, n, ans);
        
        return answer;
    }
}