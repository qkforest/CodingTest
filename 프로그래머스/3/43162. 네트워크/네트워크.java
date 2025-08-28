class Solution {
    private static int[] parents;
    private int find(int a) {
        if(parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
    private void union(int a , int b) {
        int aParent = find(a);
        int bParent = find(b);
        if(aParent == bParent) {
            return;
        }
        if(aParent < bParent) {
            parents[bParent] = aParent;
        } else {
            parents[aParent] = bParent;
        }
    }
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for(int i = 1; i < n; i++) {
            parents[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || computers[i][j] == 0) {
                    continue;
                }
                union(i, j);
            }
        }
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int p = find(parents[i]);
            if(!visited[p]) {
                visited[p] = true;
                answer++;
            }
        }
        return answer;
    }
}