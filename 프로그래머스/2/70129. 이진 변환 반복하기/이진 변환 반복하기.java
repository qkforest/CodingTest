class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            answer[0]++;
            int count = 0;
            for(char c : s.toCharArray()) {
                if(c == '0') {
                    count++;
                }
            }
            answer[1] += count;
            s = Integer.toString(s.length() - count, 2);
        }
        return answer;
    }
}