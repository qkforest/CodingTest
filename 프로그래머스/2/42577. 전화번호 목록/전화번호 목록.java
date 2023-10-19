import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        Set<Integer> len = new TreeSet<>();
        
        for(String phone: phone_book){
            set.add(phone);
            len.add(phone.length());
        }
        
        for(String phone: phone_book) {
            for(int i : len){
                if(i >= phone.length())
                    break;
                if(set.contains(phone.substring(0, i)))
                    return false;
            }
            
        }
        
        return answer;
    }
}