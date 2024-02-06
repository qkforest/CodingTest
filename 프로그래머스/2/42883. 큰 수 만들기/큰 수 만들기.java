class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k, s = 0;
        while(answer.length() != len){
            int max = 0, leftLen = k + answer.length() + 1;
            for(int i = s; i < leftLen; i++){
                int temp = number.charAt(i) - '0';
                if(temp == 9){
                    max = 9;
                    s = i+1;
                    break;
                }
                if(temp > max) {
                    max = temp;
                    s = i+1;
                }
            }
            answer.append(String.valueOf(max));
        }
        return answer.toString();
    }
}