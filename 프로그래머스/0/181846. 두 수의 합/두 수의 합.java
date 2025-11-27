import java.math.BigInteger;
class Solution {
    public String solution(String a, String b) {
        String answer = "";
        BigInteger t1 = new BigInteger(a);
        BigInteger t2 = new BigInteger(b);
        answer = String.valueOf(t1.add(t2));
        return answer;
    }
}