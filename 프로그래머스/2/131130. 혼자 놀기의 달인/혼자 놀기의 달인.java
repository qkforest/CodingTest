import java.util.*;
class Solution {
    static int num;
    public int solution(int[] cards) {
        int answer = 0;
        num = cards.length;
        for(int i = 0; i < num; i++){
            boolean[] visited = new boolean[num];
            int temp1 = game(cards, visited, i , 0);
            if(temp1 == num) 
                continue;
            for(int j = 0; j < num; j++){
                if(!visited[j]){
                    int temp2 = game(cards, visited, j, 0);
                    answer = Math.max(answer, temp1 * temp2);
                }
            }
        }
        return answer;
    }
    public int game(int[] cards, boolean[] visited, int idx, int temp){
        while(!visited[idx]){
            visited[idx] = true;
            temp++;
            idx = cards[idx]- 1; 
        }
        return temp;
    }
}