class Solution {
    private boolean isPrime(Long n) {
        if(n == 1) {
            return false;
        }
        for(long i = 2; i <= (long)Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray()) {
            if(c == '0') {
                if(sb.length() == 0) {
                    continue;
                }
                if(isPrime(Long.parseLong(sb.toString()))) {
                    answer++;
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if(sb.length() > 0 && isPrime(Long.parseLong(sb.toString()))) {
            answer++;
        }
        return answer;
    }
}