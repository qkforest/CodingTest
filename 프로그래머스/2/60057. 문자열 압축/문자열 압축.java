import java.util.*;
class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        for(int size = 1; size < len-1; size++){
            String pre = s.substring(0, size);
            String temp = "";
            int start = size;
            int count = 1;
            while(start < len){
                int end = start+size;
                if(end > len)
                    end = len;                   
                String now = s.substring(start, end);
                if(pre.equals(now)){
                    count++;   
                }else{
                    if(count == 1){
                        temp += pre;
                    }else{
                        temp += (String.valueOf(count)+pre);
                    }
                    pre = now;
                    count = 1;
                }
                start += size;
            }
            if(count > 1)
                temp += (String.valueOf(count)+pre);
            else
                 temp += pre;
            if(temp.length() < answer)
                answer = temp.length();
        }
        return answer;
    }
}