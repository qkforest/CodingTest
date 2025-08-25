import java.util.*;

class Solution {
    private long find(Map<Long, Long> parents, long room) {
        if(!parents.containsKey(room)) {
            parents.put(room, room+1);
            return room;
        }
        
        long next = find(parents, parents.get(room));
        parents.put(room, next);
        return next;
    }
    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        
        Map<Long, Long> parents = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            answer[i] = find(parents, room_number[i]); 
        }
        
        return answer;
    }
}