class Solution {
    public int combination(int n, int r){
        if(n ==r || r == 0) return 1;
        return combination(n-1, r-1) + combination(n-1,r);
    }
    public int solution(int balls, int share) {
        int answer = combination(balls, share);
        return answer;
    }
}