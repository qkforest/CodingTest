import java.util.*;
public class Solution {
    public int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public int solution(int[] arrows) {
        int answer = 0;
        
        Map<String, Vertex> vertices = new HashMap<>();
        Vertex now = new Vertex(0, 0);
        vertices.put(now.id, now);
        
        for (int idx : arrows) {
            for (int i = 0; i < 2; i++) {
                int x = now.x + directions[idx][1];
                int y = now.y + directions[idx][0];
                String id = Vertex.id(x, y);

                if (!vertices.containsKey(id)) {
                    vertices.put(id, new Vertex(x, y));
                } else if (!now.connectedvertices.contains(id)) {
                    answer++;
                }

                Vertex next = vertices.get(id);
                now.connectedvertices.add(next.id);
                next.connectedvertices.add(now.id);
                now = vertices.get(id);
            }
        }
        
        return answer;
    }
    
    public static class Vertex {
        public int x;
        public int y;
        public String id;
        public Set<String> connectedvertices;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = id(x, y);
            this.connectedvertices = new HashSet<>();
        }

        public static String id(int x, int y) {
            return String.format("(%d, %d)", x, y);
        }
    }
}