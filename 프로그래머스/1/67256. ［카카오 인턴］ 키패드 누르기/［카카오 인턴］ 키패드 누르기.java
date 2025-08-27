class Solution {
    private static final int[][] pos = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        int[] now;
        
        for(int n : numbers) {
            now = pos[n];
            if(n == 1 || n == 4 || n == 7) {
                left = now;
                sb.append("L");
            } else if(n == 3 || n == 6 || n == 9) {
                right = now;
                sb.append("R");
            } else {
                int l = Math.abs(now[0] - left[0]) + Math.abs(now[1] - left[1]);
                int r = Math.abs(now[0] - right[0]) + Math.abs(now[1] - right[1]);
                if(l < r) {
                    left = now;
                    sb.append("L");
                } else if(l > r){
                    right = now;
                    sb.append("R");
                } else {
                    if(hand.equals("left")) {
                        left = now;
                        sb.append("L");   
                    } else {
                        right = now;
                        sb.append("R");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}