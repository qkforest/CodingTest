class Solution {
    private static final int[] dy = {1, 0, -1};
    private static final int[] dx = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int v = 1;
        int d = 0;
        int y = 0;
        int x = 0;
        
        while(true) {
            arr[y][x] = v++;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny == n || ny == -1 || nx == n || ny == -1 || arr[ny][nx] != 0) {
                d = (d+1) % 3;
                ny = y + dy[d];
                nx = x + dx[d];
                if(ny == n || ny == -1 || nx == n || ny == -1 || arr[ny][nx] != 0) {
                    break;
                }
            }
            y = ny;
            x = nx;
        }
        int[] answer = new int[v-1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}