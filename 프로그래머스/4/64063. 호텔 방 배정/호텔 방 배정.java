import java.util.*;

class Solution {
    private static Map<Long, Long> rooms;
    private static long assignRoom(long room) {
        if(!rooms.containsKey(room)) {
            rooms.put(room, room+1);
            return room;
        }
        long next = assignRoom(rooms.get(room));
        rooms.put(room, next);
        return next;
    }
    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        rooms = new HashMap<>();
        for(int i = 0; i < len; i++) {
            answer[i] = assignRoom(room_number[i]);
        }
        return answer;
    }
}