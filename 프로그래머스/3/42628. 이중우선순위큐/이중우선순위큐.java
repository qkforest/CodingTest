import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Integer min, max;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
        for(String op : operations){
            switch(op.charAt(0)){
                case 'I':
                    queue.offer(Integer.parseInt(op.substring(2)));
                    queue2.offer(Integer.parseInt(op.substring(2)));
                    break;
                case 'D':
                    if(op.equals("D -1")){
                        min = queue.poll();
                        if(min != null)
                            queue2.remove(min);
                    }else {
                       max = queue2.poll();
                        if(max != null)
                            queue.remove(max); 
                    }
            }
        }
        if(queue.size() != 0){
            answer[0] = queue2.poll();
            answer[1] = queue.poll();
        }
        return answer;
    }
}