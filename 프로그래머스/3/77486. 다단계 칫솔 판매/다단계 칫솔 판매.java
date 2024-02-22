import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int num = enroll.length;
        int[] answer = new int[num];
        Map<String, Integer> idx = new HashMap<>();
        Map<String, Integer> ref = new HashMap<>();
        
        for(int i = 0; i < num; i++)
            idx.put(enroll[i], i);
        
        for(int i = 0; i < num; i++){
            if(referral[i].equals("-")) 
                ref.put(enroll[i], num);
            else
                ref.put(enroll[i], idx.get(referral[i]));
        }
        
        for(int i = 0; i < seller.length; i++){
            String now = seller[i];
            int cost = amount[i] * 100;
            while(ref.containsKey(now)){
                int j = idx.get(now);
                int next = (int)Math.floor(cost * 0.1);
                if(next >= 1)
                    answer[j] += Math.ceil(cost * 0.9);
                else{
                    answer[j] += cost;
                    break;
                }
                cost = next;
                if(ref.get(now) < num)
                    now = enroll[ref.get(now)];
                else
                    now = "center";
            }
        }
        return answer;
    }
}