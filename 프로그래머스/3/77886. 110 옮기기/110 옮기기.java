import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = s;
        for(int i = 0; i < answer.length; i++)
            answer[i] = change(answer[i]);
        return answer;
    }
    public String change(String s){
        StringBuilder sb = new StringBuilder();
		StringBuilder p = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
			sb.append(s.charAt(i));
            int idx = sb.length();
			if(idx >= 3 && sb.charAt(idx-3) == '1' && sb.charAt(idx-2) == '1' && sb.charAt(idx-1) == '0'){
				p.append("110");
				sb.delete(idx-3, idx);
			}
		}
        if(p.length() > 0) {
			if(sb.indexOf("0") == -1)
				sb.insert(0, p);
			else 
				sb.insert(sb.lastIndexOf("0")+1, p);
		}
        return sb.toString();
    }
}