import java.util.*;
class Solution {
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        Character top;
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else{
                top = stack.pop();
                if(top != s.charAt(i)){
                    stack.push(top);
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }
}