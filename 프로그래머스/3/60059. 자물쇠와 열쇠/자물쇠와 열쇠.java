import java.util.*;
class Solution {
    static int counts = 0;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int N = key.length;
        int M = lock.length;
        int size = M + 2 * N - 2;
        int[][] checkMap = new int[size][size];
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                checkMap[N-1+i][N-1+j] = lock[i][j];
            }
        }
        
        for(int i = 0; i < 4; i++){
            if(check(key, checkMap, N, M, size)){
                answer = true;
                break;
            }
            key = rotate(key, N);
        }
        return answer;
    }
    
    public int[][] rotate(int[][] ori, int N){
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                temp[i][j] = ori[N-1-j][i];
        }
        return temp;
    }
    
    public boolean check(int[][] key, int[][] checkMap, int N, int M, int size){
        for(int i = 0; i < checkMap.length-N+1; i++){
            for(int j = 0; j < checkMap.length-N+1; j++){
                int[][] temp = new int[size][size];
                boolean isKey = true;
                for(int y = 0; y < size; y++){
                    for(int x = 0; x < size; x++){
                        temp[y][x] = checkMap[y][x];
                    }
                }
                for(int k = 0; k < N; k++){
                    for(int l = 0; l < N; l++)
                        temp[i+k][j+l] += key[k][l];
                }
                for(int y = 0; y < M; y++){
                    for(int x = 0; x < M; x++){
                        if(temp[N-1+y][N-1+x] != 1){
                            isKey = false;
                            break;
                        }
                    }
                    if(!isKey)
                        break;
                }
                if(isKey)
                    return true;
            }
        }
        return false;
    }
}