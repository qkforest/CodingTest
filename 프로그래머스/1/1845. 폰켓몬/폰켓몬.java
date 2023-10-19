import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> dic = new HashMap<> ();
        
        for(int i = 0; i < nums.length; i++){
            int c = 1;
            if(dic.containsKey(nums[i]))
                c = dic.get(nums[i])+1;
            dic.put(nums[i], c);
        }
        
        if (dic.size() > nums.length / 2)
            answer = nums.length / 2;
        else
            answer = dic.size();
        
        return answer;
    }
    
}