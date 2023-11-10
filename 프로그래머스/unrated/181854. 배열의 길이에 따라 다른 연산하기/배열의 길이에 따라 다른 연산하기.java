class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr.clone();
        if(answer.length % 2 != 0){
            for(int i = 0; i <= answer.length / 2; i++){
                answer[i*2] += n;
            }
        } else {
            for(int i = 0; i < answer.length / 2; i++){
                answer[i*2+1] += n;
            }
        }
        return answer;
    }
}