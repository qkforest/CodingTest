import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;
        for(int start = 0; start < len; start++) {
            boolean vaild = true;
            Deque<Character> stack = new ArrayDeque<>();
            for(int l = 0; l < len; l++) {
                char c = s.charAt((start+l) % len);
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    continue;
                }
                if(c == ')') {
                    if(stack.isEmpty() || stack.peekFirst() != '(') {
                        vaild = false;
                        break;
                    }
                } else if(c == '}') {
                    if(stack.isEmpty() || stack.peekFirst() != '{') {
                        vaild = false;
                        break;
                    }
                } else {
                    if(stack.isEmpty() || stack.peekFirst() != '[') {
                        vaild = false;
                        break;
                    }
                }
                stack.pop();
            }
            if(!stack.isEmpty()) {
                vaild = false;
            }
            if(vaild) {
                answer++;
            }
        }
        return answer;
    }
}