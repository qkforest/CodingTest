class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        for(int[] q: queries){
            for(int i = q[0]; i < q[1]+1; i++)
                answer[i] += 1;
        }
        return answer;
    }
}