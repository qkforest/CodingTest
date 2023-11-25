import java.util.*;
class Solution {
    public boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public int solution(String dartResult) {
        int answer = 0;
        String num = "";
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < dartResult.length(); i++){
            if(isNumber(String.valueOf(dartResult.charAt(i)))){
                num += dartResult.charAt(i);
            } else{
                switch(dartResult.charAt(i)){
                    case 'S':
                        stack.push(Double.parseDouble(num));
                        num = "";
                        break;
                    case 'D':
                        stack.push(Math.pow(Integer.parseInt(num), 2));
                        num = "";
                        break;
                    case 'T':
                        stack.push(Math.pow(Integer.parseInt(num), 3));
                        num = "";
                        break;
                    case '*':
                        if(stack.size() == 1){
                            Double a = stack.pop();
                            stack.push(2*a);
                        } else{
                            Double a = stack.pop();
                            Double b = stack.pop();
                            stack.push(2*b);
                            stack.push(2*a);
                        }
                        break;
                    case '#':
                        Double a = stack.pop();
                        stack.push(-a);
                        break;  
                }
            }
        }
        while(!stack.isEmpty()){
            double a = stack.pop();
            answer += (int)a;
        }
        return answer;
    }
}