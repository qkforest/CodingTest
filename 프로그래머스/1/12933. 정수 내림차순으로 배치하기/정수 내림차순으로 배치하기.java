import java.util.*;
class Solution {
    public long solution(long n) {
        String answer = "";
        Integer[] arr = new Integer[String.valueOf(n).length()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = String.valueOf(n).charAt(i) - '0';
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++)
            answer += arr[i];
        return Long.parseLong(answer);
    }
}