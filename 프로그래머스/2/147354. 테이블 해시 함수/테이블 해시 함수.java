import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[col-1] == o2[col-1]){
                    return o2[0] - o1[0];
                }
                return o1[col-1] - o2[col-1];
            }
        });

        for(int i = row_begin; i <= row_end; i++){
            int now = 0;
            for(int j = 0; j < data[0].length; j++)
            now += (data[i-1][j] % i);
            if(i != row_begin){
                now = (answer ^ now); 
            }
            answer = now;
        }
        return answer;
    }
}