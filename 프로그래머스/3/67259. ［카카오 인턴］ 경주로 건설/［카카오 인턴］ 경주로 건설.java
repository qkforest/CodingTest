import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 500 * n * n;
        int[][][] visited = new int[n][n][4];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, -1, 0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.r == n-1 && now.c == n-1){
                answer = Math.min(answer, now.cost);
            }
            for(int i = 0 ; i < 4; i++){
                int r = now.r + directions[i][0];
                int c = now.c +  directions[i][1];
                if(r < 0 || r >= n || c < 0 || c >= n || board[r][c] == 1) {
                    continue;
                }
                int nextcost = now.cost;
                if(now.d == -1 || now.d == i){
                    nextcost += 100;
                }else{
                    nextcost += 600;
                }
                if(visited[r][c][i] == 0 || board[r][c] >= nextcost){
                    q.add(new Node(r, c, i, nextcost));
                    board[r][c] = nextcost;
                    visited[r][c][i] = 1;
                }
            }
        }
        return answer;
    }
    
    public class Node {
        int r, c, d, cost;

        public Node(int r, int c, int d, int cost) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }
}