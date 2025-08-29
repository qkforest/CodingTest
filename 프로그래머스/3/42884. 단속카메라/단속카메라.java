import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = routes[0][1];
        for(int[] r : routes) {
            if(r[0] > camera) {
                answer++;
                camera = r[1];
            }
        }
        return answer;
    }
}