import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String temp = Long.toString(n,k);
        for(String s: temp.split("0")){
            if(s.equals(""))
                 continue;
            else {
                boolean flag = true;
                if(s.equals("1"))
                    flag = false;
                else if(!s.equals("2")){
                    for(int i = 2; i <= Math.sqrt(Long.parseLong(s)); i++){
                        if(Long.parseLong(s) % i == 0){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag)
                    answer+=1;
            }
        }
        return answer;
    }
}