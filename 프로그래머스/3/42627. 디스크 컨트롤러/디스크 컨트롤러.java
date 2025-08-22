import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        
        PriorityQueue<int[]> jobQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> readyQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int[] job : jobs) {
            jobQueue.offer(job);
        }
        
        while(!jobQueue.isEmpty() || !readyQueue.isEmpty()) {
            while(!jobQueue.isEmpty() && jobQueue.peek()[0] <= time) {
                readyQueue.offer(jobQueue.poll());
            }
            if(readyQueue.isEmpty()) {
                time = jobQueue.peek()[0];
            } else {
                int[] job = readyQueue.poll();
                time += job[1];
                answer += time - job[0];
            }
        }
        
        return answer / jobs.length;
    }
}