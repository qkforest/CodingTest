import java.util.*;
class Solution {
    public int[][] cost = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    public int solution(int[] picks, String[] minerals) {
        int answer = 0, counts = 0, temp = 0, idx = 0, start = 0, m = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o2[1] - o1[1]);
        
        for(int p : picks)
            counts += p;
        
        for(int i = 1; i <= minerals.length; i++){
            if(counts == 0)
                break;
            else{
                switch(minerals[i-1]){
                    case "diamond": 
                        temp += 25;
                        break;
                    case "iron": 
                        temp += 5;
                        break;
                    case "stone": 
                        temp += 1;
                        break;
                }
                if(i % 5 == 0 || i == minerals.length){
                    q.add(new int[]{start, temp});
                    temp = 0;
                    start = i;
                    counts--;
                }
            }
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            while(picks[idx] == 0)
                idx++;
            for(int i = now[0]; i < now[0]+5; i++){
                if(i == minerals.length) break;
                if(minerals[i].equals("diamond")) 
                    m = 0;
                else if(minerals[i].equals("iron"))
                    m = 1;
                else
                    m = 2;
                answer += cost[idx][m];
            }
            picks[idx] -= 1;
        }
        return answer;
    }
}