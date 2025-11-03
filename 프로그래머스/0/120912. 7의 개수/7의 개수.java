class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int num : array){
            for(int i = 0; i < String.valueOf(num).length(); i++){
                if(String.valueOf(num).charAt(i) - '0' == 7)
                    answer++;
            }
        }
        return answer;
    }
}