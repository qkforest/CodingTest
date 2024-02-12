import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] matrix = new int[rows][columns];
        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = num++;
            }
        }
        for(int[] q: queries){
            int cnt = 0;
            int r = q[0]-1;
            int c = q[1]-1;
            int previous = matrix[r][c];
            int min = num;
            while(cnt < 4){
                switch(cnt){
                    case 0:
                        if(c < q[3]-1){
                            c++;
                            int temp = matrix[r][c];
                            matrix[r][c] = previous;
                            previous = temp;
                        } else cnt++;
                        break;
                    case 1:
                        if(r < q[2]-1){
                            r++;
                            int temp = matrix[r][c];
                            matrix[r][c] = previous;
                            previous = temp;
                        } else cnt++;
                        break;
                    case 2:
                        if(c > q[1]-1){
                            c--;
                            int temp = matrix[r][c];
                            matrix[r][c] = previous;
                            previous = temp;
                        } else cnt++;
                        break;
                    case 3:
                        if(r > q[0]-1){
                            r--;
                            int temp = matrix[r][c];
                            matrix[r][c] = previous;
                            previous = temp;
                        } else cnt++;
                        break;
                }
                if(min > previous) min = previous;
            }
            answer.add(min);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}