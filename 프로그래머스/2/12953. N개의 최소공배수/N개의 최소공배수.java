import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0], min = 0;
        boolean search;
        for(int i = 1; i < arr.length; i++){
            search = true;
            min = answer > arr[i] ? answer : arr[i];
            while(search){
                if(min % answer == 0 && min % arr[i] == 0){
                    search = false;
                    answer = min;
                } else
                    min ++;
            }
        } 
        return answer;
    }
}