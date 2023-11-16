import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] q = quiz[i].split(" ");
            System.out.println(Arrays.toString(q));
            switch(q[1]){
                case "+":
                    if(Integer.parseInt(q[4]) == Integer.parseInt(q[0]) + Integer.parseInt(q[2]))
                        answer[i] = "O";
                    else
                        answer[i] = "X";
                    break;
                case "-":
                    if(Integer.parseInt(q[4]) == Integer.parseInt(q[0]) - Integer.parseInt(q[2]))
                        answer[i] = "O";
                    else
                        answer[i] = "X";
                    break;
                
            }
        }
        return answer;
    }
}