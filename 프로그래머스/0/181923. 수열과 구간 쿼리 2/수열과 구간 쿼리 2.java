import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] slice = Arrays.copyOfRange(arr, queries[i][0], queries[i][1] + 1);
            int k = queries[i][2];
            slice = Arrays.stream(slice).filter(x -> x > k).toArray();
            if(slice.length == 0)
                answer[i] = -1;
            else {
                Arrays.sort(slice);
                answer[i] = slice[0];
            }
                
        }
        return answer;
    }
}