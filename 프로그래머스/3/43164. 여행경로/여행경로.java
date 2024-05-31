import java.util.*;
class Solution {
    public String[] answer;
    public boolean[] visited;
    public int len;
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        answer = new String[len+1];
        visited = new boolean[len];
        String[] temp = new String[len+1];
        temp[0] = "ICN";
        dfs(1, "ICN",  temp, tickets);
        return answer;
    }
    public void dfs(int level, String from, String[] temp, String[][] tickets) {
        if(level == len+1) {
            if(answer[0] == null) {
                answer = temp.clone();
            }
            else{
                for(int i = 0; i < len; i++) {
                    if(temp[i].compareTo(answer[i]) < 0) {
                        answer = temp.clone();
                        break;
                    } else if(answer[i].compareTo(temp[i]) < 0) {
                        break;
                    }
                }
            }
            return;
        }
        for(int i = 0; i < len; i++) {
            if(tickets[i][0].equals(from) && !visited[i]) {
                visited[i] = true;
                temp[level] = tickets[i][1];
                dfs(level+1, tickets[i][1], temp, tickets);
                visited[i] = false;
            }
        }
    }
}