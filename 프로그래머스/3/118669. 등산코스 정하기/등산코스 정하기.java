import java.util.*;
class Solution {
    public static ArrayList<Node>[] list;
    public static int[] nodes;
    public static int[] intensity;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        nodes = new int[n+1];
        intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        for(int g : gates) {
            nodes[g] = -1;
        }
        for(int s : summits) {
            nodes[s] = -2;
        }
        for(int[] p : paths) {
            int s = p[0];
            int e = p[1];
            if(nodes[s] == -1 || nodes[e] == -2) {
                list[s].add(new Node(e, p[2]));
            }
            else if(nodes[e] == -1 || nodes[s] == -2){
                list[e].add(new Node(s, p[2]));
            }
            else {
                list[s].add(new Node(e, p[2]));
                list[e].add(new Node(s, p[2]));
            }
        }
        dijkstra();
        int[] answer = {0, Integer.MAX_VALUE};
        Arrays.sort(summits);
        for(int s : summits) {
            if(intensity[s] < answer[1]) {
                answer[1] = Math.min(answer[1], intensity[s]);
                answer[0] = s;
            }
        }
        return answer;
    }
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i] == -1) {
                pq.offer(new Node(i, 0));
                intensity[i] = 0;
            }
        }
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(intensity[now.idx] < now.weight) {
                continue;
            }
            for(Node next : list[now.idx]) {
                if(intensity[next.idx] > Math.max(intensity[now.idx], next.weight)) {
                    intensity[next.idx] = Math.max(intensity[now.idx], next.weight);
                    pq.offer(next);
                }
            }
        }
    }
    public static class Node {
        int idx;
        int weight;
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}