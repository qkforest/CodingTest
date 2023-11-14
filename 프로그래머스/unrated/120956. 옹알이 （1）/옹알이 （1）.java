import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        String[] pos = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for(String b : babbling){
            if(Arrays.asList(pos).contains(b))
                answer += 1;
            else {
                int s = 0, ans = 0;
                List<String> check = new ArrayList<>();
                for(int i = 1; i <= b.length(); i++){
                    String temp = b.substring(s, i);
                    if(!check.contains(temp) && Arrays.asList(pos).contains(temp)){
                        check.add(temp);
                        s = i;
                        ans += temp.length();
                    }
                }
                if(ans == b.length())
                    answer += 1;
            }
        }
        return answer;
    }
}