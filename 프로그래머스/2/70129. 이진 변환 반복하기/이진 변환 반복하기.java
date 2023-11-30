class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        while(!s.equals("1")){
            answer[0] += 1;
            count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1')
                    count++;
            }
            answer[1] += s.length() - count;
            s = Integer.toBinaryString(count);
        }
        return answer;
    }
}