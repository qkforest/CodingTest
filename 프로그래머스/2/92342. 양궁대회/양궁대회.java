import java.util.*;
class Solution {
    private int max = 0;
    private int[] answer = {-1};
    private void dfs(int start, int n, int[] info, int[] temp) {
        if(start == 11 && n > 0) {
            return;
        }
        if(n == 0) {
            int scoreR = 0;
            int scoreP = 0;
            for(int i = 0; i < 11; i++) {
                if(info[i] == 0 && temp[i] == 0) {
                    continue;
                }
                if(info[i] >= temp[i]) {
                    scoreP += 10 - i;
                } else {
                    scoreR += 10 - i;
                }
            }
            if(scoreR <= scoreP) {
                return;
            }
            if(scoreR - scoreP > max) {
                max = scoreR - scoreP;
                answer = temp.clone();
            } else if(scoreR - scoreP == max) {
                for(int i = 10; i >= 0; i--) {
                    if(answer[i] == temp[i]) {
                        continue;
                    } else if(answer[i] > temp[i]) {
                        break;
                    } else {
                        answer = temp.clone();
                        break;
                    }
                }
            }
            return;
        }
        for(int i = start; i < 11; i++) {
            for(int j = 0; j <= n; j++) {
                temp[i] = j;
                dfs(i+1, n - j, info, temp);
                temp[i] = 0;
            }
        }
    }
    public int[] solution(int n, int[] info) {
        dfs(0, n, info, new int[11]);
        return answer;
    }
}