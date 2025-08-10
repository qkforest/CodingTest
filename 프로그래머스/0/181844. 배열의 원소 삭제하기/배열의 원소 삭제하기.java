import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        for(int i : arr)
            answer.add(i);
        for(int n : delete_list)
            answer.remove(Integer.valueOf(n));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}