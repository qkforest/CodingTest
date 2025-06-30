import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    int time;
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        for(int[] route: routes) {
            time = 0;
            pos(points[route[0]-1][0], points[route[0]-1][1]);
            for(int i = 1; i < route.length; i++) {
                find(points[route[i-1]-1][0], points[route[i-1]-1][1], points[route[i]-1][0], points[route[i]-1][1]);
            }
        }
        for(int c : map.values()) {
            if(c > 1) {
                answer++;
            }
        }
        return answer;
    }
    public void find(int sr, int sc, int dr, int dc) {
        while(sr != dr) {
            time++;
            if(sr > dr) {
                sr--;
            } else {
                sr++;
            }
            pos(sr, sc);
        }
        while(sc != dc) {
            time++;
            if(sc > dc) {
                sc--;
            } else {
                sc++;
            }
            pos(sr, sc);
        }
    }
    public void pos(int r, int c){
        StringBuilder sb = new StringBuilder();
        sb.append(r).append("/").append(c).append("/").append(time);
        map.merge(sb.toString(), 1, Integer::sum);
    }
}