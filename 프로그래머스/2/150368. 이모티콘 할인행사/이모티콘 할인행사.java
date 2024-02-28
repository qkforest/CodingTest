import java.util.*;
class Solution {
    static int[] sales = {10, 20, 30, 40};
    static int[] sale;
    static int num;
    static int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        num = emoticons.length;
        sale = new int[num];
        dfs(0, users, emoticons);
        return answer;
    }
    public void dfs(int level, int[][] users, int[] emoticons){
        if(level == num){
            int sum = 0, sub = 0;
            for(int[] user : users){
                int userSum = 0;
                for(int i = 0; i < num; i++){
                    if(sale[i] >= user[0])
                        userSum += emoticons[i] * (100-sale[i]) * 0.01;
                }
                if(userSum >= user[1])
                    sub++;
                else
                    sum += userSum;
            }
            if(sub > answer[0]){
                answer[0] = sub;
                answer[1] = sum;
            } 
            else if(sub == answer[0] && sum > answer[1])
                answer[1] = sum;
        }else{
            for(int i = 0; i < sales.length; i++){
                sale[level] = sales[i];
                dfs(level+1, users, emoticons);
            }
        }
    }
}