import java.util.*;
class Solution {
    public static char[] numArray, temp;
    public static boolean[] visited;
    public static List<Integer> answer;
    public static int len;
    
    public int solution(String numbers) {
        numArray = numbers.toCharArray();
        answer = new ArrayList<>();
        len = numArray.length;
        temp = new char[len];
        visited = new boolean[len];
        
        for(int i = 1; i <= len; i++) dfs(0, i);
        
        return answer.size();
    }
    
    public void dfs(int level, int size){
        if(level == size){
            String s = "";
            for(char c : temp){
                if(c != 0) s += c;
            }
            int n = Integer.parseInt(s);
            if(!answer.contains(n) && n > 1){
                if(check(n)) answer.add(n);
            }
        } else {
            for(int i = 0; i < len; i++){
                if(!visited[i]){
                    visited[i] = true;
                    temp[level] = numArray[i];
                    dfs(level+1, size);
                    visited[i] = false;
                }
            }
        }
    }
    
    public boolean check(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}