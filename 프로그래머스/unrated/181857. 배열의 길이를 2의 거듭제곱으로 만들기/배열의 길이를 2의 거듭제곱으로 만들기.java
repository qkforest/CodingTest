import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Integer[] len = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        if(Arrays.asList(len).contains(arr.length))
            answer = arr.clone();
        else{
            int l = 0;
            for(int n : len){
                if(n > arr.length){
                    l = n;
                    break;
                }
            }
            int[] temp = new int[l-arr.length];
            Arrays.fill(temp,  0);
            answer = IntStream.concat(Arrays.stream(arr), Arrays.stream(temp)).toArray();
        }
        return answer;
    }
}