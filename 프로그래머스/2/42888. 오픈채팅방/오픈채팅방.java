import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> mem = new HashMap<>();
        for(String r : record){
            String[] temp = r.split(" ");
            switch(temp[0]){
                case "Enter":
                    answer.add("E " + temp[1]);
                    mem.put(temp[1], temp[2]);
                    break;
                case "Leave":
                    answer.add("L " + temp[1]);
                    break;
                case "Change":
                    mem.put(temp[1], temp[2]);
                    break;
            }
        }
        int i = 0;
        for(String a : answer){
            String[] temp = a.split(" ");
            switch(temp[0]){
                case "E":
                    answer.set(i, mem.get(temp[1])+"님이 들어왔습니다.");
                    break;
                case "L":
                    answer.set(i, mem.get(temp[1])+"님이 나갔습니다.");
                    break;
            }
            i++;
        }
        return answer.toArray(new String[answer.size()]);
    }
}