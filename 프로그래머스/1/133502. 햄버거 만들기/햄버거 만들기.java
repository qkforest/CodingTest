import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ingredient.length; i++){
            if(ingredient[i] == 1){
                if(stack.empty())
                    stack.push(1);
                else {
                    Integer top = stack.pop();
                    if(top == 3){
                        stack.pop();
                        stack.pop();
                        answer++;
                    } else {
                        stack.push(top);
                        stack.push(1);
                    }
                }
            }
            else if(ingredient[i] == 2){
                if(!stack.empty()){
                    Integer top = stack.pop();
                    if(top == 1){
                        stack.push(1);
                        stack.push(2);
                    } else
                        stack.clear();
                 }
            } else{
                if(!stack.empty()){
                    Integer top = stack.pop();
                    if(top == 2){
                        stack.push(2);
                        stack.push(3);
                    } else
                        stack.clear();
                 }
            }
        }
        return answer;
    }
}