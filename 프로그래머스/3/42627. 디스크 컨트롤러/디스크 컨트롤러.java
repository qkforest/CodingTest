import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        
        PriorityQueue<int[]> jobsQ = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> readyQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for(int i = 0; i < jobs.length; i++){
            jobsQ.offer(jobs[i]);
        }
        
        while(!jobsQ.isEmpty() || !readyQ.isEmpty()){
            while(!jobsQ.isEmpty() && jobsQ.peek()[0] <= time){
                readyQ.offer(jobsQ.poll());
            }
            if(readyQ.isEmpty()){
                time = jobsQ.peek()[0];
            }
            else{
                int[] work = readyQ.poll();
                answer += (time+work[1]-work[0]);
                time += work[1];
            }
        }
        return answer/jobs.length;
    }
}