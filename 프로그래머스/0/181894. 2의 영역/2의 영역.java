import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        int s = -1, e = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                s = i;
                break;
            }
        }
        for(int i = arr.length-1; i > -1; i--){
            if(arr[i] == 2){
                e = i;
                break;
            }
        }
        if(s >= 0){
            if(s == e)
                answer[0] = arr[s];
            else
                answer = Arrays.copyOfRange(arr, s, e+1);
        }
        return answer;
    }
}