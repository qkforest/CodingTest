import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        for(int n : arr){
            int[] temp= new int[n];
            Arrays.fill(temp, n);
            answer = IntStream.concat(Arrays.stream(answer), Arrays.stream(temp)).toArray();
        }
        return answer;
    }
}