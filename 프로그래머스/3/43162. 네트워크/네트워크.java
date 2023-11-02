class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                answer++;
                dfs(i, computers, visited);
            }
        }
        return answer;
    }
    public void dfs(int i, int[][] computers, int[] visited){
        visited[i] = 1;
        
        for(int k = 0; k < computers.length; k++){
            if(visited[k] == 0 && computers[i][k] == 1)
                dfs(k, computers, visited);
        }
        
    }
}