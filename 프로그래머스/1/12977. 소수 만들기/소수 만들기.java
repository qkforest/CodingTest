import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean isDecimal;
        List<Integer> sum = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++)
                    sum.add(nums[i]+nums[j]+nums[k]);
            }
        }
        for(int n : sum){
            isDecimal = true;
            //System.out.println(n);
            for(int i = 2; i < n ; i++){
                if(n % i == 0){
                    isDecimal = false;
                    break;
                }
            }
            if(isDecimal)
                answer++;
        }
        return answer;
    }
}