class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(Character.isLowerCase(c)) {
                sb.append(c);
            }
            else if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if((c >= '0' && c <= '9') || c == '-' || c =='_') {
                sb.append(c);
            } else if(c == '.' && sb.length() > 0 && sb.charAt(sb.length()-1) != '.') {
                sb.append(c);
            }
        }
        if(sb.length() == 0) {
            sb.append('a');
        }
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') {
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length() < 3) {
            int len = sb.length();
            char c = sb.charAt(len-1);
            for(int i = 0; i < 3-len; i++) {
                sb.append(c);
            }
        }
        if(sb.length() > 15) {
            sb.delete(15, sb.length());
            if(sb.charAt(sb.length()-1) == '.') {
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}