class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k)  {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0){ 
            stack.pop();
            k--;
        }
        StringBuilder answer = new StringBuilder();
        for (Character c : stack) {
            answer.append(c);    
        }
        int i = 0;
        while(i < answer.length()-1 && answer.charAt(i) == '0'){ 
            i++;
        }
        return answer.substring(i, answer.length()).toString();
    }
}