import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            int l = commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[l];
            for(int j = commands[i][0]; j <= commands[i][1]; j++) {
                temp[j-commands[i][0]] = array[j-1]; 
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}