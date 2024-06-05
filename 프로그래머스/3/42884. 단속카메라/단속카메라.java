import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = routes[0][1];
        //System.out.println(Arrays.deepToString(routes));
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] <= camera) {
                continue;
            }
            camera = routes[i][1];
            answer++;
        }
        return answer;
    }
}