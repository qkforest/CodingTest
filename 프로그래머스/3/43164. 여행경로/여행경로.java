import java.util.*;
class Solution {
    public boolean[] visited;
    public String[] answer, temp;
    public int count, i;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        count = tickets.length+1;
        i = 0;
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        temp = new String[count];
        temp[0] = "ICN";
        dfs(1, "ICN", tickets);
        return answer;
    }
    public void dfs(int level, String start, String[][] tickets){
        boolean r = true;
        if(level == count){
            if(i == 0){
                answer = Arrays.copyOf(temp, count);
                i++;
            }
            return;
        }else{
            //System.out.println(Arrays.toString(temp));
            for(int i = 0; i < tickets.length; i++){
                if(start.equals(tickets[i][0])){
                    if(!visited[i]){
                        r = false;
                        visited[i] = true;
                        temp[level] = tickets[i][1];
                        dfs(level+1, tickets[i][1], tickets);
                        visited[i] = false;
                    }
                }
           }
           if(r) return;
       }
    }
}