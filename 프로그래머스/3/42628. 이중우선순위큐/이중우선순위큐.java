import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int size = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(String o : operations) {
            String[] arr = o.split(" ");
            int n = Integer.parseInt(arr[1]);
            if(arr[0].equals("I")) {
                min.offer(n);
                max.offer(n);
                size++;
            } else {
                if(size != 0) {
                    if(n == 1) {
                        int m = max.poll();
                        min.remove(m);
                    } else {
                        int m = min.poll();
                        max.remove(m);
                    }
                    size--;
                    if(size == 0) {
                        min.clear();
                        max.clear();
                    }
                }
            }
        }
        
        if(size != 0) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        return answer;
    }
}