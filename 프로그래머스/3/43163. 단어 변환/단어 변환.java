class Solution {
    private int answer;
    private void dfs(String now, String target, int cnt, String[] words, boolean[] visited) {
        if(cnt == words.length){
            return;
        }
        if(now.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i = 0 ; i < words.length; i++) {
            if(!visited[i]) {
                int d = 0;
                for(int j = 0; j < now.length(); j++) {
                    if(now.charAt(j) != words[i].charAt(j)) {
                        d++;
                    }
                    if(d > 1) {
                        break;
                    }
                }
                if(d == 1) {
                    visited[i] = true;
                    dfs(words[i], target, cnt+1, words, visited);
                    visited[i] = false;
                }
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        dfs(begin, target, 0, words, new boolean[words.length]);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}