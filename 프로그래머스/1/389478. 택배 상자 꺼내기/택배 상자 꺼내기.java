class Solution {
    public int solution(int n, int w, int num) {
        int height = n / w;
        if( n % w != 0) {
            height++;
        }
        int[][] boxes = new int[height][w];
        int c = 0;
        int r = height - 1;
        int idx = 1;
        int d = 1;
        
        while(idx <= n) {
            boxes[r][c] = idx;
            if(idx % w == 0) {
                r--;
                d *= (-1);
                if(d == -1 && c == w - 1) {
                    c = w;
                }
                if(d == 1 && c == 0) {
                    c = -1;
                }
            }
            c += d;
            idx++;
        }
        
        for(int i = 0; i < w; i++) {
            int start = 0;
            if(boxes[0][i] == 0) {
                start = 1;
            }
            for(int j = 1; j < height; j++) {
                if(boxes[j][i] == num) {
                    return j - start  + 1;
                }
            }
        }
        
        return 1;
    }
}