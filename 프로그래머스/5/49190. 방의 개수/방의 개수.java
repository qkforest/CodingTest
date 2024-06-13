import java.util.*;
public class Solution {
    public int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public int solution(int[] arrows) {
        int answer = 0;
        
        Map<String, Edge> edges = new HashMap<>();
        Edge v = new Edge(0, 0);
        edges.put(v.id, v);
        
        for (int idx : arrows) {
            for (int i = 0; i < 2; i++) {
                int x = v.x + directions[idx][1];
                int y = v.y + directions[idx][0];
                String id = Edge.id(x, y);

                if (!edges.containsKey(id)) {
                    edges.put(id, new Edge(x, y));
                } else if (!v.connectedEdges.contains(id)) {
                    answer++;
                }

                Edge u = edges.get(id);
                v.connectedEdges.add(u.id);
                u.connectedEdges.add(v.id);
                v = edges.get(id);
            }
        }
        
        return answer;
    }
    
    public static class Edge {
        public int x;
        public int y;
        public String id;
        public Set<String> connectedEdges;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = id(x, y);
            this.connectedEdges = new HashSet<>();
        }

        public static String id(int x, int y) {
            return String.format("(%d, %d)", x, y);
        }
    }
}