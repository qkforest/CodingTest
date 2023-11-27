class Solution {
    public int solution(String s) {
        int answer = 0, idx = 0, f = 0, fCount = 0, cCount = 0, lidx = 0;
        char fir, com;
        while(idx < s.length()){
            fir = s.charAt(f);
            if(s.charAt(f) == s.charAt(idx))
                fCount++;
            else
                cCount++;
            if(fCount == cCount){
                lidx = idx+1;
                answer++;
                f = idx + 1;
            }
            idx++;  
        }
        if(lidx < s.length())
            answer++;
        return answer;
    }
}