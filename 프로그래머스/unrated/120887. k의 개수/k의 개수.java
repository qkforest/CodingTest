class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int idx = i; idx <= j; idx++){
            for(char c: String.valueOf(idx).toCharArray()){
                if(c - '0' == k)
                    answer += 1;
            }
        }
        return answer;
    }
}