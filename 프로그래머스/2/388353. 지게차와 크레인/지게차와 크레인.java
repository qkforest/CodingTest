import java.util.*;

class Solution {
    private static final int[][] directions ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int n, m;
    private static Set<String> end;
    private static boolean[][] visited;
    
    private void next(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y, x});
        boolean[][] v = new boolean[n][m];
        v[y][x] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int[] d : directions) {
                int ny = now[0] + d[0];
                int nx = now[1] + d[1];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || v[ny][nx]) {
                    continue;
                }
                if(!visited[ny][nx]){
                    v[ny][nx] = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ny).append(" ").append(nx);
                    end.add(sb.toString());
                } else {
                    v[ny][nx] = true;
                    q.offer(new int[] {ny, nx});
                }
            }
        }
        
    }
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        int answer = n * m;
        Map<Character, Set<String>> map = new HashMap<>();
        end = new HashSet<>();
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char c = storage[i].charAt(j);
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(" ").append(j);
                Set<String > set = map.getOrDefault(c, new HashSet<>());
                set.add(sb.toString());
                map.put(c, set);
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    end.add(sb.toString());
                }
            }
        }
        
        for(String request : requests) {
            char c = request.charAt(0);
            
            if(!map.containsKey(c)) {
                continue;
            }
            
            Set<String> set = map.get(c);
            List<String> list = new ArrayList<>();
            
            // 해당 알파벳 컨테이너 중 가장자리에 위치하는 것 구하기
            for(String pos : set) {
                if(end.contains(pos)) {
                    list.add(pos);
                }
            }
            
            // 해당 알파벳 컨테이너 중 가장자리에 위치하는 것 삭제하기(len == 1 && len == 2)
            for(String pos : list) {
                String[] p = pos.split(" ");
                int y = Integer.parseInt(p[0]);
                int x = Integer.parseInt(p[1]);
                visited[y][x] = true;
                answer--;
                next(y, x);
                end.remove(pos);
                set.remove(pos);
            }
            
            if(request.length() == 2) {
                for(String pos : set) {
                    String[] p = pos.split(" ");
                    int y = Integer.parseInt(p[0]);
                    int x = Integer.parseInt(p[1]);
                    visited[y][x] = true;
                    answer--;
                    if(end.contains(pos)) {
                        next(y, x);
                        end.remove(pos);
                    }
                }
            }
            if(set.isEmpty() || request.length() == 2) {
                map.remove(c);
            } else {
                map.put(c, set);   
            }
        }
        
        return answer;
    }
}