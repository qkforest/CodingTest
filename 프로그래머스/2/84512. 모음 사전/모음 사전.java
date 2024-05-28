import java.util.*;
class Solution {
    public String[] alphabets = {"A", "E", "I", "O", "U"};
    public List<String> list;
    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        dfs("", 0);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public void dfs(String s, int len) {
        list.add(s);
        if(len == 5){
            return;
        }
        for(int i = 0; i < 5; i++) {
            dfs(s+alphabets[i], len+1);
        }
    }
}