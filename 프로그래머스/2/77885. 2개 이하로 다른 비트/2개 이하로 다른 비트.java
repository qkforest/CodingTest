class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int cnt = 0;
        for(int i = 0; i < numbers.length; i++){
            String num = Long.toBinaryString(numbers[i]);
            String temp = "";
            cnt = 0;
            for(int j = num.length() - 1; j >= 0; j--){
                if(num.charAt(j) == '0'){
                    if(temp.length() >= 2) temp = "10" + temp.substring(1);
                    else if(temp.length() == 1) temp = "10";
                    else temp = "1";
                    cnt++;
                    break;
                } else temp = num.charAt(j) + temp;
            }
            if(cnt == 0) temp = "10" + num.substring(1);
            else temp = num.substring(0, num.length()-temp.length()) + temp;
            answer[i] = Long.parseLong(temp, 2);
        }
        return answer;
    }
}