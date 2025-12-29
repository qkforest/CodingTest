class Solution {
    public int solution(int chicken) {
        int answer = 0, coupon = 0;
        if(chicken >= 10){
            while(chicken >= 1){
                coupon += (chicken % 10);
                chicken /= 10;
                answer += chicken;
            }
        }
        while(coupon >= 10){
            answer += coupon / 10;
            coupon = coupon / 10 + coupon % 10;
        }
        return answer;
    }
}