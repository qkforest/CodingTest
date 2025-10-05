import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int total = friends.length;
        int[][] count = new int[total+1][total+1];
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for(String friend : friends) {
            map.put(friend, idx++);
        }
        
        for(String gift : gifts) {
            String[] arr = gift.split(" ");
            int A = map.get(arr[0]);
            int B = map.get(arr[1]);
            count[A][B]++;
            count[A][0]++;
            count[0][B]++;
        }
        
        int[] next = new int[total+1];
        for(int i = 1; i <= total; i++) {
            for(int j = i + 1; j <= total; j++) {
                if(count[i][j] == count[j][i]) {
                    int A = count[i][0] - count[0][i];
                    int B = count[j][0] - count[0][j];
                    if(A > B) {
                       next[i]++; 
                    } else if(A < B) {
                        next[j]++;
                    }
                } else if(count[i][j] > count[j][i]) {
                    next[i]++;
                } else {
                    next[j]++;
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= total; i++) {
            answer = Math.max(answer, next[i]);
        }
        
        return answer;
    }
}