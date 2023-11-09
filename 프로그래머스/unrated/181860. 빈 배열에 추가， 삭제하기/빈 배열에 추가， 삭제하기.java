import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        for(int i = 0; i < flag.length; i++){
            if(flag[i]){
                int[] temp = new int[arr[i]*2];
                Arrays.fill(temp, arr[i]);
                answer = IntStream.concat(Arrays.stream(answer), Arrays.stream(temp)).toArray();
            } else 
                answer = Arrays.copyOfRange(answer, 0, answer.length-arr[i]);
        }
        return answer;
    }
}