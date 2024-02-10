import java.util.*;
class Solution {
    List<String> temp;
    Stack<Character> stack = new Stack();
    String answer;
    public String solution(String p) {
        answer = "";
        temp = new ArrayList<>();
        revise(p);
        return answer;
    }
    public void revise(String w){
        if(w.length() == 0) return;
        else{
            int left = 0, right = 0, idx = 0;
            for(char c: w.toCharArray()){
                if(c == '(') left++;
                if(c == ')') right++;
                if(left == right && (left > 0 && right > 0)) break;
                else idx++;
            }
            String u = w.substring(0, idx+1);
            stack.clear();
            boolean bal = true;
            for(char c : u.toCharArray()){
                if(c != '('){
                    if(stack.isEmpty()){
                        bal = false;
                        break;
                    } else stack.pop();
                } else stack.push(c);
            }
            if(bal){
                answer += u;
                revise(w.substring(idx+1));
            }else{
                answer += "(";
                revise(w.substring(idx+1));
                answer += ")";
                String re = "";
                for(int i = 1; i < u.length()-1; i++){
                    if(u.charAt(i) == '(') re += ')';
                    else re += '(';
                }
                answer += re;
            }
        }
    } 
}