class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i = 1;
        int len = digits.length;
        while(i < len && digits[i - 1] <= digits[i]) {
            i++;
        }
        if (i < len) {
            while(i > 0 && digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                i--;
            }
            i++;
            while(i < len) {
                digits[i] = '9';
                i++;
            }
        }
        return Integer.parseInt(new String(digits));
    }
}