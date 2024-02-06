import java.util.*;
class Solution {
    public int[] solution(int n) {
        int len = n*(n+1)/2;
        int[] answer = new int[len];
        int i = 0, idx = 0, flag = 1, plus = 0, count = 0;
        while(i < len){
            int limit = n > 1 ? n-1 : 1;
            if(flag == 1){
                if(count == limit) {
                    flag++;
                    count = 0;
                }else{
                    i++;
                    answer[idx] = i;
                    plus++;
                    idx += plus;
                    count++;
                }
            }
            else if(flag == 2){
                if(count == limit) {
                    flag++;
                    count = 0;
                    plus += 1;
                }else {
                    i++;
                    answer[idx] = i;
                    idx++;
                    count++;
                }
            } else {
                if(count == limit) {
                    flag = 1;
                    count = 0;
                    idx += plus;
                    n -= 3;
                } else{
                    i++;
                    answer[idx] = i;
                    count++;
                    if(count != n-1){
                        idx -= (plus);
                        plus--;
                    }
                }
            }
        }
        return answer;
    }
}