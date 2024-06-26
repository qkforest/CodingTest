class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] answer = new int[n];
        List<Node>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
		int INF = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)  {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            graph[edge[0]].add(new Node(edge[1], edge[2]));
            graph[edge[1]].add(new Node(edge[0], edge[2]));
        }
        Arrays.fill(answer, INF);
        answer[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0));
        while(!pq.isEmpty()) {
			int now = pq.poll().idx;
			if(!visited[now]) {
                visited[now] = true;
                for(Node next : graph[now]) {
                    if(answer[next.idx] > answer[now] + next.time) {
                        if(answer[now] + next.time < disappear[next.idx]) {
                            answer[next.idx] = answer[now] + next.time;
                            pq.offer(new Node(next.idx, answer[next.idx]));
                        }
                    }
                }
            }
		}
        for(int i = 1; i < n; i++) {
            if(answer[i] >= disappear[i]) {
                answer[i] = -1;
            }
        }
        return answer;
    }
    public class Node implements Comparable<Node> {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }
}