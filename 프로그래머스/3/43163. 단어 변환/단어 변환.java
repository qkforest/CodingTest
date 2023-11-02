import java.util.*;

class Node{
    String word;
    int count;
    Node(String word, int count){
        this.count = count;
        this.word = word;
    }
}

class Solution {
    int[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new int[words.length];
        if(Arrays.asList(words).contains(target))
            answer = bfs(begin, target, words); 
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node c = queue.poll();
            if(c.word.equals(target)) return c.count;
            for(int i = 0; i < words.length ;i++){
                int match = 0;
                for(int j = 0; j < begin.length(); j++)
                    if(c.word.charAt(j) == words[i].charAt(j)) match++;
                if(visited[i] == 0 && match == begin.length()-1){
                    queue.add(new Node(words[i], c.count+1));
                    visited[i] = 1;
                }
            }
        }
        return 0;
    }
}