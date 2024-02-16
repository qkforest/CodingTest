import java.util.*;
class Solution {
    static List<int[]> answer;
    public int[][] solution(int n) {
        answer = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        return answer.stream().toArray(int[][]::new);
    }
    public void hanoi(int n, int start, int mid, int end){
        if(n==0)
            return;
        hanoi(n-1, start, end, mid);
        answer.add(new int[]{start, end});
        hanoi(n-1, mid, start, end);
    }
}