import java.util.*;
class Solution {
    public Set<long[]> stars;
    public int[] lines;
    long startX = Long.MAX_VALUE, startY = Long.MAX_VALUE, endX = Long.MIN_VALUE, endY = Long.MIN_VALUE;
    public String[] solution(int[][] line) {
        stars = new HashSet<>();
        lines = new int[2];
        dfs(0, 0 , line);
        char[][] ans = new char[(int)(endY-startY+1)][(int)(endX-startX+1)];
        for(int i = 0; i < endY-startY+1; i++)
            Arrays.fill(ans[i], '.');
        for(long[] s : stars)
            ans[(int)(s[1]-startY)][(int)(s[0]-startX)] = '*';
        String[] answer = new String[(int)(endY-startY+1)];
        for(int i = 0 ; i < answer.length; i++)
            answer[i] = new String(ans[answer.length-1-i]);
        return answer;
    }
    public void dfs(int s, int level, int[][] line){
        if(level == 2){
            long A = line[lines[0]][0];
            long B = line[lines[0]][1];
            long E = line[lines[0]][2];
            long C = line[lines[1]][0];
            long D = line[lines[1]][1];
            long F = line[lines[1]][2];
            double x = (B*F-E*D)/(double)(A*D-B*C);
            double y = (E*C-A*F)/(double)(A*D-B*C);
            if(A*D - B*C != 0 && (x == (long)x && y == (long)y)){
                startX = Math.min(startX, (long)x);
                startY = Math.min(startY, (long)y);
                endX = Math.max(endX, (long)x);
                endY = Math.max(endY, (long)y);
                stars.add(new long[]{(long)x, (long)y});
            }
        }else{
            for(int i = s; i < line.length; i++){
                lines[level] = i;
                dfs(s+1, level+1, line);
            }
        }
    }
}