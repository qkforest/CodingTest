import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean member = true;
        Map<String, Integer> w = new HashMap<>(), copy = new HashMap<>();
        for(int i = 0; i < number.length; i++){
            w.put(want[i], number[i]);
        }
        for(int i = 0; i < discount.length; i++){
            member = true;
            copy.putAll(w);
            if(w.containsKey(discount[i])){
                if(i+10 <= discount.length){
                    for(int j = i; j < i+10; j++){
                        if(copy.containsKey(discount[j]))
                            copy.put(discount[j], copy.get(discount[j])-1);
                    }
                }
            }
            for(int n : copy.values()){
                if(n > 0){
                    member = false;
                    break;
                } 
            }
            if(member)
                answer++;
        }
        return answer;
    }
}