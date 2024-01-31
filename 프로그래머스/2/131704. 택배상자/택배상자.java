import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> extra = new Stack<>();
        for(int i = 1; i <= order.length; i++){
            if(i == order[answer]) answer += 1;
            else extra.push(i);
            if(!extra.isEmpty()){
                int e = extra.peek();
                if(e == order[answer]) {
                    extra.pop();
                    answer += 1;
                }
            }
        }
        if(!extra.isEmpty()){
            while(true){
                if(extra.isEmpty()) break;
                else {
                    int e = extra.pop();
                    if(e == order[answer]) answer += 1;
                    else break;
                }
            }
        }
        return answer;
    }
}