import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] his = new boolean[11][11][4];
        int r = 5, c = 5, nr = 0, nc = 0, d = 0;
        int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
        for(char ch : dirs.toCharArray()){
            switch(ch){
                case 'U':
                    d = 0;
                    break;
                case 'D':
                    d = 2;
                    break;
                case 'R':
                    d = 1;
                    break;
                case 'L':
                    d = 3;
                    break;
            }
            nc = c + dc[d];
            nr = r + dr[d];
            if(nr < 0 || nr > 10 || nc < 0 || nc > 10) continue;
            if(!his[nr][nc][d]){
                his[nr][nc][d] = true;
                d = (d%2 == 0) ? 2-d : 4-d;
                his[r][c][d] = true;
                answer++;
            }
            c = nc;
            r = nr;
        }
        return answer;
    }
}