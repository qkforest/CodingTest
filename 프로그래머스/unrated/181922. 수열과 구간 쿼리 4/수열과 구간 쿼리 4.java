class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for (int[] q: queries){
            for(int i = q[0]; i <= q[1]; i++){
                if(q[2] == 0)
                    continue;
                else{   
                    if(i % q[2] == 0)
                        arr[i] += 1;
                }
            }
            
        }
        answer = arr;
        return answer;
    }
}