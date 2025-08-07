import java.util.*;

class Solution {
    private static Set<Integer> set;
    private static char[] num;
    private static boolean[] visited;
    private static int len;
    
    private void dfs(int level, StringBuilder sb) {
        if(level == len) {
            return;
        }
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(num[i]);
                int n = Integer.parseInt(sb.toString());
                if(isPrime(n)){
                    set.add(n);
                }
                dfs(level+1, sb);
                sb.deleteCharAt(level);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if(n == 1 || n == 0) {
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(String numbers) {
        set = new HashSet<>();
        num = numbers.toCharArray();
        len = num.length;
        visited = new boolean[len];
        dfs(0, new StringBuilder());
        return set.size();
    }
}