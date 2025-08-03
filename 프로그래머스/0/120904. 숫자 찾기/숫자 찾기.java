class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        for(int i = 0; i < String.valueOf(num).length(); i++){
            if(String.valueOf(num).charAt(i) - '0' == k){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}