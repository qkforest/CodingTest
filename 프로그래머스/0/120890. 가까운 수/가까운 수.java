import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0], d = Math.abs(n - array[0]);
        for(int i = 1; i < array.length; i++){
            if(Math.abs(n - array[i]) < d){
                d = Math.abs(n - array[i]);
                answer = array[i];
            } 
            else if(Math.abs(n - array[i]) == d){
                if(answer > array[i])
                    answer = array[i];
            } 
        }
        return answer;
    }
}