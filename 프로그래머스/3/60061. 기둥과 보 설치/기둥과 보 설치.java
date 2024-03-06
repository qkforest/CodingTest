class Solution {
    boolean[][] pillar;
    boolean[][] bar;
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];
        int count = 0;
        for(int[] build : build_frame){
            int x = build[0];
            int y = build[1];
            if(build[2] == 0){
                if(build[3] == 1){
                    if(checkPillar(x, y)){
                        pillar[x][y] = true;
                        count++;
                    }  
                } else{
                    pillar[x][y] = false;
                    if(!canRemove(n)) 
                        pillar[x][y] = true;
                    else 
                        count--;
                }
            } else {
                if(build[3] == 1){
                    if(checkBar(x, y)){
                        bar[x][y] = true;
                        count++;
                    } 
                } else{
                    bar[x][y] = false;
                    if(!canRemove(n)) 
                        bar[x][y] = true;
                    else 
                        count--;
                }
            }
        }
        int[][] answer = new int[count][3];
        int idx = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j; 
                    answer[idx++][2] = 0;
                }
                if(bar[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }
    public boolean checkPillar(int x, int y){
        if(y == 0) 
            return true;
        else if(y > 0 && pillar[x][y - 1]) 
            return true;
        else if(x > 0 && bar[x - 1][y] || bar[x][y]) 
            return true;
        return false;
    }
    public boolean checkBar(int x, int y){
        if(y > 0 && pillar[x][y-1] || pillar[x+1][y-1]) 
            return true;
        else if(x > 0 && bar[x-1][y] && bar[x+1][y]) 
            return true;
        return false;
    }
    public boolean canRemove(int n){    
        for(int i = 0; i <= n; i++){ 
            for(int j = 0; j <= n; j++){ 
                if(pillar[i][j] && !checkPillar(i, j)) 
                    return false; 
                else if(bar[i][j] && !checkBar(i, j)) 
                    return false;
            }
        }
        return true;
    }
}