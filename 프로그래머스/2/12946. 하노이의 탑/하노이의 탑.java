import java.util.*;
class Solution {
    private void hanoi(int n, int from, int to, List<int[]> answer) {
        if(n == 1) {
            answer.add(new int[] {from, to});
            return;
        }
        int empty = 6 - from - to;
        hanoi(n-1, from, empty, answer);
        hanoi(1, from , to, answer);
        hanoi(n-1, empty, to, answer);
    }
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        hanoi(n, 1 , 3, answer);
        return answer.toArray(new int[0][]);
    }
}