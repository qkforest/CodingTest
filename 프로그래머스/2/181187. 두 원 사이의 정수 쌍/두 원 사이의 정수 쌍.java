class Solution {
    public long solution(int r1, int r2) {
        long answer = r2-r1+1;
        for(int i = 1; i <= r1; i++){
            double y1 = Math.sqrt(r1*r1 - i*i);
            double y2 = Math.sqrt(r2*r2 - i*i);
            if(y2 == (int)y2)
                y2 += 1.0;
            answer += (int)y2 - (int)y1;
        }
        for(int i = r1 + 1; i < r2; i++){
            double y2 = Math.sqrt(r2*r2 - i*i);
            if(y2 == (int)y2)
                y2 += 1.0;
            answer += (int)y2;
        }
        return 4*answer;
    }
}