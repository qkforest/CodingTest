import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int now = 2;
        int turn = 1;
        
        for(int i = 1; i < words.length; i++){
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                System.out.println(words[i].charAt(0));
                System.out.println(words[i-1].charAt(words[i-1].length()-1));
                answer[0] = now;
                answer[1] = turn;
                break;
            }
            for(String s : Arrays.copyOfRange(words, 0, i)) {
                if(words[i].equals(s)) {
                    answer[0] = now;
                    answer[1] = turn;
                    break;
                }
            }
            if(answer[0] != 0)
                break;
            
            now += 1;
            if(now > n){
                now = 1;
                turn += 1;
            }
        }
        return answer;
    }
}