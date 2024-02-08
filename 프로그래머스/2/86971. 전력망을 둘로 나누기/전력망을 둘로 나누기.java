import java.util.*;
class Solution {
    public boolean[] connect, visited;
    public int answer;
    public int solution(int n, int[][] wires) {
        answer = n;
        for(int i = 0; i < n; i++){
            connect = new boolean[n+1];
            visited = new boolean[n+1];
            bfs(i, n, wires); 
        }
        return answer;
    }
    public void bfs(int idx, int n, int[][] wires){
        Queue<Integer> q = new LinkedList<>();
        int t = idx > 0 ? 0 : 1;
        q.add(wires[t][0]);
        q.add(wires[t][1]);
		connect[wires[t][0]] = true;
        connect[wires[t][1]] = true;
        visited[t] = true;

		while (!q.isEmpty()) {
			int f = q.poll();
			for (int i = 0; i < wires.length; i++) {
				if(!visited[i] && (wires[i][0] == f || wires[i][1] == f)){
                    if(i != idx){
                        q.add(wires[i][0]);
                        q.add(wires[i][1]);
                        connect[wires[i][0]] = true;
                        connect[wires[i][1]] = true;
                        visited[i] = true;
                    }
				}
			}
		}
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(connect[i]) count++;
        }
        if(Math.abs(n-(count*2)) <= answer) {
            answer = Math.abs(n-(count*2));
        }
    }
}