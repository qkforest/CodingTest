import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0, count = 0;
        String temp;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            stack.clear();
            count = 0;
            temp = s.substring(i, s.length()) + s.substring(0, i);
            for(char c : temp.toCharArray()){
                if(c == '(' || c == '['|| c == '{')
                    stack.push(c);
                else {
                    if(stack.empty())
                        break;
                    else {
                        char t = stack.pop();
                        if(c == ')' && t != '(')
                            break;
                        else if(c == '}' && t != '{')
                            break;
                        else if(c == ']' && t != '[')
                            break;
                    }
                }
                count++;
            }
            if(count == s.length() && stack.empty())
                answer++;
        }
        return answer;
    }
}