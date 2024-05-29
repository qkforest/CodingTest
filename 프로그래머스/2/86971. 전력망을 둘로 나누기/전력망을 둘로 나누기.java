import java.util.*;
class Solution {
    public boolean[] visitedWire;
    public boolean[] visitedTower;
    public int answer, len;
    public int solution(int n, int[][] wires) {
        answer = n;
        len = wires.length;
        for(int i = 0; i < len; i++) {
            visitedWire = new boolean[len];
            visitedTower = new boolean[n+1];
            visitedWire[i] = true;
            bfs(i, n, wires);
        }
        return answer;
    }
    public void bfs(int idx, int n, int[][] wires) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        int start = wires[idx][0];
        q.add(start);
        visitedTower[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < len; i++){
                if(!visitedWire[i]) {
                    if(wires[i][0] == now && !visitedTower[wires[i][1]]) {
                        q.add(wires[i][1]);
                        count++;
                        visitedWire[i] = true;
                    }
                    if(wires[i][1] == now && !visitedTower[wires[i][0]]) {
                        q.add(wires[i][0]);
                        count++;
                        visitedWire[i] = true;
                    }
                }
            }
        }
        answer = Math.min(answer, Math.abs(count-(n-count)));
    }
}