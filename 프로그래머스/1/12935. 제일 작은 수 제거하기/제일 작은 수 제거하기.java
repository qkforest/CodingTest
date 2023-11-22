import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer =  new ArrayList<>();
        int[] copy = arr.clone();
        Arrays.sort(copy);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != copy[0])
                answer.add(arr[i]);
        }
        return arr.length > 1 ? answer.stream().mapToInt(Integer::intValue).toArray() : new int[] {-1};
    }
}