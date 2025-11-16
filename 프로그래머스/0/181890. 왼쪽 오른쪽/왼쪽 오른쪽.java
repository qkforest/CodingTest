import java.util.*;
class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        int idx = 0;
        String c = "";
        
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l") || str_list[i].equals("r")){
                idx = i;
                c = str_list[i];
                break;
            }
            idx += 1;   
        }
        if(c.equals("l")){
            answer = Arrays.copyOfRange(str_list, 0, idx);
        }
        if(c.equals("r")){
            answer = Arrays.copyOfRange(str_list, idx+1, str_list.length);
        }
                     
        return answer;
    }
}