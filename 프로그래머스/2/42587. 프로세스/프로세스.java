import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0, p = 0;
        boolean comp = true;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            p = queue.poll();
            comp = true;
            Iterator<Integer> iter = queue.iterator();
            while(iter.hasNext()){
                Integer i = iter.next();
                if(priorities[p] < priorities[i]){
                    queue.add(p);
                    comp = false;
                    break;
                }
            }
            if(comp){
                answer++;
                if(p == location)
                    break;
            }
        }
        return answer;
    }
}