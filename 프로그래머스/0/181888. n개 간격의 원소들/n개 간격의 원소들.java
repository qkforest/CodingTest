import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        int idx = n;
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < num_list.length; i++){
            if(idx == n){
                temp.add(num_list[i]);
                idx = 0;
            }
            idx += 1;
        }
        answer = temp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}