import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String[][] keypads = {{"1", "4", "7", "*"}, {"2", "5", "8", "0"}, {"3", "6", "9", "#"}};
        int[] lPos = {0, 3}, rPos = {2, 3};
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < keypads.length; j++){
                for(int k = 0; k < keypads[0].length; k++){
                    if(keypads[j][k].equals(String.valueOf(numbers[i]))){
                        if(j == 0){
                            answer += "L";
                            lPos[0] = j; lPos[1] = k;
                        } else if (j == 2){
                            answer += "R";
                            rPos[0] = j; rPos[1] = k;
                        } else {
                            if(Math.abs(j - lPos[0])+Math.abs(k - lPos[1]) < Math.abs(j - rPos[0])+Math.abs(k - rPos[1])){
                                answer += "L";
                                lPos[0] = j; lPos[1] = k;
                            } else if(Math.abs(j - lPos[0])+Math.abs(k - lPos[1]) > Math.abs(j - rPos[0])+Math.abs(k - rPos[1])){
                                answer += "R";
                                rPos[0] = j; rPos[1] = k;
                            } else {
                                if(hand.equals("right")){
                                    answer += "R";
                                    rPos[0] = j; rPos[1] = k;
                                } else {
                                    answer += "L";
                                    lPos[0] = j; lPos[1] = k;
                                }
                            }  
                        }
                    }
                }
            }
        }
        return answer;
    }
}