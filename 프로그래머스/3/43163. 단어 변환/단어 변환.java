class Solution {
    public boolean[] visited;
    public int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        if(answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }
    public void dfs(String now, String target, String[] words, int count) {
        if(now.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && diff(now, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
    public boolean diff(String a, String b){
        int count = 0;
        int len = a.length();
        for(int i = 0; i < len; i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        if(count == 1) {
            return true;
        }
        return false;
    }
}