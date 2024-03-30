import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int n) {
        dfs(n, "(", 1, 0);
        return answer;
    }
    public void dfs(int len, String s, int left, int right){
        if(s.length() == 2*len-1){
            if(check(s+")"))
                answer++;
            return;
        }
        if(left < len)
            dfs(len, s+'(', left+1, right);
        if(right < len-1)
            dfs(len, s+')', left, right+1);
    }
    public boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push('(');
            else{
                if(!stack.isEmpty())
                    stack.pop();
                else
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}