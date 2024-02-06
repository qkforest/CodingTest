import java.util.*;
class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder("");
        int temp = 0, count = 0;
        String[] idx = {"1", "2", "4"};
        boolean stop = false; 
        while(true){
            if(temp + (int)Math.pow(3, count+1) <= n){
                temp += (int)Math.pow(3, count+1);
                count++;
                if(temp == n) stop = true;
            } else break;  
        }
        if(stop) answer.append("4".repeat(count));
        else{
            count++;
            answer.append("1".repeat(count));
            temp += 1;
            String edit = "";
            int a = n - temp, r = 0, time = 1;
            while(a > 0){
                r = a % 3;
                a /= 3;
                answer.replace(count-time, count-time+1, idx[r]);
                edit = idx[r] + edit;
                time++;
            }
        }
        return answer.toString();
    }
}