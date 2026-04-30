import java.util.*;

class Solution {
    public int start, end;
    public Set<String> words;
    
    public void addWords(int start, int end, String message) {
        if(start > 0 && message.charAt(start-1) != ' ') {
            while(start < end && message.charAt(start) != ' ') {
                start++;
            }
            start++;
        }
        
        if(end >= 0 && end < message.length() - 1 && message.charAt(end + 1) != ' ') {
            while(start < end && message.charAt(end) !=  ' ') {
                end--;
            }
        }
        
        if(start <= end) {
            String[] temp = message.substring(start, end+1).trim().split(" ");
            if(temp.length > 0) {
                for(String w : temp) {
                    words.add(w);
                }
            }
        }
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        start = 0;
        end = 0;
        words = new HashSet<>();
        Set<String> important = new HashSet<>();
        
        for(int[] r : spoiler_ranges) {
            end = r[0] - 1;
            addWords(start, end, message);
            start = r[1] + 1;
        }
        
        end = message.length() - 1;
        addWords(start, end, message);
        
        Set<String> siginicant = new HashSet<>();
        
        for(int[] r : spoiler_ranges) {
            while(r[0] > 0 && message.charAt(r[0] - 1) != ' ') {
                r[0]--;
            }
            while(r[1] < message.length() - 1 && message.charAt(r[1] + 1) != ' ') {
                r[1]++;
            }
            String[] temp = message.substring(r[0], r[1]+1).trim().split(" ");
            if(temp.length > 0) {
                for(String w : temp) {
                    if(!words.contains(w)){
                        siginicant.add(w);
                    }
                }
            }
        }
        
        return siginicant.size();
    }
}