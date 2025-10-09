import java.util.*;

class Solution {
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private class Robot implements Comparable<Robot>{
        int status;
        int[] pos;
        int time;
        
        public Robot(int status, int[] pos, int time) {
            this.status = status;
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Robot other) {
            return this.time - other.time;
        }
        
    }
    
    private String posToString(int[] pos) {
        StringBuilder sb = new StringBuilder();
        sb.append(pos[0]).append(" ").append(pos[1]).append(" ").append(pos[2]).append(" ").append(pos[3]);
        return sb.toString();
    }
    
    private int bfs(int[][] board) {
        Set<String> visited = new HashSet<>();
        Queue<Robot> q = new LinkedList<>();
        int[] start = {0, 0, 0, 1};
        q.offer(new Robot(1, start, 0));
        visited.add(posToString(start));
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        while(!q.isEmpty()) {
            Robot now = q.poll();
            if((now.pos[0] == n-1 && now.pos[1] == m-1) || (now.pos[2] == n-1 && now.pos[3] == m-1)) {
                answer = now.time;
                break;
            }
            for(int[] d : directions) {
                int ny1 = now.pos[0] + d[0];
                int nx1 = now.pos[1] + d[1];
                int ny2 = now.pos[2] + d[0];
                int nx2 = now.pos[3] + d[1];
                int[] n1 = new int[] {ny1, nx1, ny2, nx2};
                String p = posToString(n1);
                
                if(ny1 < 0 || ny2 < 0 || nx1 < 0 || nx2 < 0 || ny1 >= n || ny2 >= n || nx1 >= m || nx2 >= m || board[ny1][nx1] == 1 || board[ny2][nx2] == 1 || visited.contains(p)) {
                    continue;
                }
                
                visited.add(p);
                q.offer(new Robot(now.status, n1, now.time + 1));  
            }
            
            int[] n1;
            int[] n2;
            String p;
            
            if(now.status == 1) {
                int ny = now.pos[0] - 1;
                int nx1 = now.pos[1];
                int nx2 = now.pos[3];
                if(ny >= 0 && ny < n && board[ny][nx1] == 0 && board[ny][nx2] == 0) {
                    n1 = new int[] {ny, nx1, now.pos[0], nx1};
                    p = posToString(n1);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n1, now.time + 1));  
                    }
                    n2 = new int[] {ny, nx2, now.pos[0], nx2};
                    p = posToString(n2);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n2, now.time + 1));  
                    }
                }
                ny = now.pos[0] + 1;
                if(ny >= 0 && ny < n && board[ny][nx1] == 0 && board[ny][nx2] == 0) {
                    n1 = new int[] {now.pos[0], nx1, ny, nx1};
                    p = posToString(n1);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n1, now.time + 1));  
                    }
                    n2 = new int[] {now.pos[0], nx2, ny, nx2};
                    p = posToString(n2);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n2, now.time + 1));  
                    }
                }
            } else {
                int nx = now.pos[1] - 1;
                int ny1 = now.pos[0];
                int ny2 = now.pos[2];
                if(nx >= 0 && nx < m && board[ny1][nx] == 0 && board[ny2][nx] == 0) {
                    n1 = new int[] {ny1, nx, ny1, now.pos[1]};
                    p = posToString(n1);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n1, now.time + 1));  
                    }
                    n2 = new int[] {ny2, nx, ny2, now.pos[1]};
                    p = posToString(n2);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n2, now.time + 1));  
                    }
                }
                nx = now.pos[1] + 1;
                if(nx >= 0 && nx < m && board[ny1][nx] == 0 && board[ny2][nx] == 0) {
                    n1 = new int[] {ny1, now.pos[1], ny1, nx};
                    p = posToString(n1);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n1, now.time + 1));  
                    }
                    n2 = new int[] {ny2, now.pos[1], ny2, nx};
                    p = posToString(n2);
                    if(!visited.contains(p)) {
                        visited.add(p);
                        q.offer(new Robot(now.status * (-1), n2, now.time + 1));  
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int solution(int[][] board) {
        return bfs(board);
    }
}