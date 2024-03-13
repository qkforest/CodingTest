import java.util.*;
class Solution {
    static int max = 0;
    static int round;
    static int[] apeach;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        round = n;
        apeach = info;
        int scoreA = 0;
        for(int i = 0; i < info.length; i++){
            if(info[i] > 0)
                scoreA += (10 - i);
        }
        int[] ryan = new int[11];
        dfs(0, 0, 0, scoreA, ryan);
        if(max == 0)
            return new int[] {-1};
        return answer;
    }
    public void dfs(int n, int idx, int scoreR, int scoreA, int[] ryan){
        if(n == round){
            if(scoreR > scoreA){
                if(max < scoreR - scoreA){
                    answer = ryan.clone();
                    max = scoreR - scoreA;
                } 
                if(max == scoreR - scoreA){
                    for(int i = answer.length-1; i >= 0; i--){
                        if(answer[i] < ryan[i]){
                            answer = ryan.clone();
                            break;
                        }
                        else if(answer[i] > ryan[i])
                            break;
                    }
                }
            }
            return;
        }
        for(int i = idx; i < apeach.length; i++){
            if(round-(n+apeach[i]+1) >= 0){
                ryan[i] = apeach[i]+1;
                if(apeach[i] > 0)
                    dfs(n+apeach[i]+1, i+1, scoreR+10-i, scoreA-(10-i), ryan);
                else
                    dfs(n+apeach[i]+1, i+1, scoreR+10-i, scoreA, ryan);
            } else{
                ryan[i] = round - n;
                dfs(n+ryan[i], i+1, scoreR, scoreA, ryan);
            }
            ryan[i] = 0;
        } 
    }
}