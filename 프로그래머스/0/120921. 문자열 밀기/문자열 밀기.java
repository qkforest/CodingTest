class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        for(int i = 0; i < A.length(); i++){
            String temp = A.substring(A.length()-i) + A.substring(0, A.length()-i);
            if(temp.equals(B)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}