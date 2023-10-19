import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int total = nums.length / 2;
        
        HashMap<Integer, Integer> dic = new HashMap<> ();
        
        for(int i = 0; i < nums.length; i++){
            int c = 1;
            if(dic.containsKey(nums[i]))
                c = dic.get(nums[i])+1;
            dic.put(nums[i], c);
        }
        
        if (dic.size() > total)
            answer = total;
        else
            answer = dic.size();
        
        return answer;
    }
    
    public int factorial(int number) {
        if (number > 1) 
            return number * factorial(number - 1);
        return number;
    }
}