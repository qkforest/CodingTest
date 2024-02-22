import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        boolean[] visited = new boolean[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> s = new HashMap<>();
        Arrays.fill(answer, -1);
        for(int[] road : roads){
            if(!map.containsKey(road[0])){
                List<Integer> a = new ArrayList<>();
                a.add(road[1]);
                map.put(road[0], a);
            }else{
                List<Integer> a = new ArrayList<>();
                a = map.get(road[0]);
                a.add(road[1]);
                map.put(road[0], a);
            }
            if(!map.containsKey(road[1])){
                List<Integer> a = new ArrayList<>();
                a.add(road[0]);
                map.put(road[1], a);
            }else{
                List<Integer> a = new ArrayList<>();
                a = map.get(road[1]);
                a.add(road[0]);
                map.put(road[1], a);
            }   
        }
        for(int i = 0; i < sources.length; i++)
             s.put(sources[i], i);
        
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{destination, 0});
        visited[destination] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(s.containsKey(now[0]))
                answer[s.get(now[0])] = now[1];
            List<Integer> a = map.get(now[0]);
            for(int j : a){
                if(!visited[j]){
                    visited[j] = true;
                    q.offer(new int[]{j, now[1]+1});
                }
            }
        }
        return answer;
    }
}