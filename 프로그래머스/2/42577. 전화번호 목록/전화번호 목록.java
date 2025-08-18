import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String p : phone_book) {
            set.add(p);
        }
        for(String p : phone_book) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < p.length() - 1; i++) {
                sb.append(p.charAt(i));
                if(set.contains(sb.toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}