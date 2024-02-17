class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h;
        long g = gcd(w, h);
        long w2 = (long)w / g;
        long h2 = (long)h / g;
        answer -= (g * (w2+h2-1));
        return answer;
    }
    public int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}