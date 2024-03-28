import java.util.*;
class Solution {
    static Map<Long, Long> rooms = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for(int i = 0; i < answer.length; i++)
            answer[i] = AssignRoom(room_number[i]);
        return answer;
    }
    public long AssignRoom(long roomNum){
        if (!rooms.containsKey(roomNum)) {
            rooms.put(roomNum, roomNum+1);
            return roomNum;
        }
        long empty= AssignRoom(rooms.get(roomNum));
        rooms.put(roomNum, empty);
        return empty;
    }
}