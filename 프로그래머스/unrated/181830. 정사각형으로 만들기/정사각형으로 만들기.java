import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int h = arr[0].length;
        int w = arr.length;
        if(h == w)
            answer = arr.clone();
        else if(h > w){
            List<int[]> temp = new ArrayList<>();
            int[] t = new int[h];
            for(int i = 0; i < arr.length; i++)
                temp.add(arr[i]);
            for(int i = 0; i < h-w; i++)
                temp.add(t);
            answer = temp.stream().toArray(int[][]::new);
        } else {
            answer = new int[w][w];
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < h; j++)
                    answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}