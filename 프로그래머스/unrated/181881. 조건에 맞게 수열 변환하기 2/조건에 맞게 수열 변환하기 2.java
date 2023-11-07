import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] temp = {};
        while(!Arrays.equals(arr, temp)){
            temp = arr.clone();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= 50 && arr[i] % 2 == 0)
                    arr[i] = arr[i] / 2;
                else if(arr[i] < 50 && arr[i] % 2 != 0)
                    arr[i] = arr[i] * 2 + 1;
            }
            answer += 1;
        }
        return answer-1;
    }
}