import java.util.*;
class Solution {
    static int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static char[] charD = {'d', 'l', 'r', 'u'};
    static int N, M, R, C;
    static String answer = "";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        dfs("", x, y, k, Math.abs(R-x)+Math.abs(C-y));
        if(answer.equals(""))
            return "impossible";
        return answer;
    }
    public boolean dfs(String s, int x, int y, int k, int diff){
        if(k == 0 && diff == 0){
            answer = s;
            return true;
        }else{
            for(int i = 0; i < 4; i++){
                int nextX = x + directions[i][0];
                int nextY = y + directions[i][1];
                if(nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M && diff <= k){
                    if((diff % 2 == 0 && k % 2 == 0) || (diff % 2 == 1 && k % 2 == 1)){
                        if(dfs(s+charD[i], nextX, nextY, k-1, Math.abs(R-nextX)+Math.abs(C-nextY)))
                            return true;
                    }        
                }
            }
        }
        return false;
    }
}