import java.util.*;
class Solution {
    static char[] WORD = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;
        List<String> dic = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            dfs(dic, String.valueOf(WORD[i]));
        for(int i=0; i<dic.size(); i++){
            if(dic.get(i).equals(word)){
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
    public void dfs(List<String> dic, String w){
        if(w.length() > 5) return;
        if(!dic.contains(w))
            dic.add(w);
        for(int i = 0; i < 5; i++)
            dfs(dic, w+WORD[i]);
    }
}