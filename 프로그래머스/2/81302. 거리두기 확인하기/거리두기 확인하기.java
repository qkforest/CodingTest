import java.util.*;
class Solution {
    public int[][] directions = {{1, 0}, {0, 1}, {2, 0}, {0, 2}, {1, 1}, {1, -1}};
    public int[] solution(String[][] places) {
        int len = places.length;
        int[] answer = new int[len];
        Arrays.fill(answer, 1);
        for(int i = 0; i < len; i++){
            char[][] place = new char[5][5];
            boolean P = false;
            for(int j = 0; j < 5; j++){
                place[j] = places[i][j].toCharArray();
            }
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(place[j][k] == 'P'){
                        for(int l = 0; l < 6; l++){
                            int r = j+directions[l][0], c = k+directions[l][1];
                            if((r >= 0 && r < 5) && (c >= 0 && c < 5)){
                                if(place[r][c] == 'P'){
                                    if(l < 2){
                                        P = true;
                                        break;
                                    }
                                    else if(l == 2){
                                        if(place[r-1][c] != 'X'){
                                            P = true;
                                            break;
                                        }
                                    }
                                    else if(l == 3){
                                        if(place[r][c-1] != 'X'){
                                            P = true;
                                            break;
                                        }
                                    }
                                    else if(l == 4){
                                        if(place[r-1][c] != 'X' || place[r][c-1] != 'X'){
                                            P = true;
                                            break;
                                        }
                                    }
                                     else if(l == 5){
                                        if(r > 0){
                                            if(place[r-1][c] != 'X' || place[r][c+1] != 'X'){
                                                P = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(P){
                        break;
                    }
                }
                if(P){
                    break;
                }
            }
            if(P){
                answer[i] = 0;
            }
        }
        return answer;
    }
}