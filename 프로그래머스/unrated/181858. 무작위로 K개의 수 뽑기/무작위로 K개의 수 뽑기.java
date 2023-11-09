import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();
        for(int n : arr){
            if(answer.size() == k)
                break;
            else{
                if(!answer.contains(n)){
                    answer.add(n);
                }
            }
        }
        if(answer.size() < k){
            Integer[] temp = new Integer[k-answer.size()];
            Arrays.fill(temp, -1);
            answer.addAll(Arrays.asList(temp));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}