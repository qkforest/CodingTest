class Solution {
    public int solution(String number) {
        int answer = 0;
        int n = 0;
        for (char c : number.toCharArray()){
            n += Integer.parseInt(String.valueOf(c));
        }
        answer = n % 9;
        return answer;
    }
}