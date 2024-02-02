import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) ->{return o1[1] - o2[1];});
        Queue<int[]> cam = new LinkedList<>();
        for(int[] r : routes) cam.offer(r);
        while(!cam.isEmpty()){
            int r = cam.poll()[1];
            answer++;
            while(!cam.isEmpty()){
                int[] t = cam.peek(); 
                if(t[0] <= r && t[1] >= r) cam.poll();
                else break;
            }
        }
        return answer;
    }
}