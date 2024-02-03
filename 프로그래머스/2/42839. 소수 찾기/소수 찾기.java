import java.util.*;
class Solution {
    List<Integer> list;
    boolean[] visited;
    int size;
    char[] num, temp;
    public int solution(String numbers) {
        int answer = 0;
        num = numbers.toCharArray();
        size = numbers.length();
        list = new ArrayList<>();
        visited = new boolean[size];
        temp = new char[size];
        for(int i = 1; i <= size; i++) dfs(0, i);
        return list.size();
    }
    public void dfs(int lvl, int len){
        if(lvl == len){
            String t = "";
            for(char a: temp){
                if(a != 0) t += a;
            }
            int n = Integer.parseInt(t);
            if(!list.contains(n) && n > 1){
                if(check(n)) list.add(n);
            }
        } else{
            for(int i = 0; i < size; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    temp[lvl] = num[i];
                    dfs(lvl+1, len);
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