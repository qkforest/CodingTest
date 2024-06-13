import java.util.*;
public class Solution {
    public int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public int solution(int[] arrows) {
        int answer = 0;
        
        Map<String, Vertex> vertices = new HashMap<>();
        Vertex v = new Vertex(0, 0);
        vertices.put(v.id, v);
        
        for (int idx : arrows) {
            for (int i = 0; i < 2; i++) {
                int x = v.x + directions[idx][1];
                int y = v.y + directions[idx][0];
                String id = Vertex.id(x, y);

                if (!vertices.containsKey(id)) {
                    vertices.put(id, new Vertex(x, y));
                } else if (!v.connectedvertices.contains(id)) {
                    answer++;
                }

                Vertex u = vertices.get(id);
                v.connectedvertices.add(u.id);
                u.connectedvertices.add(v.id);
                v = vertices.get(id);
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