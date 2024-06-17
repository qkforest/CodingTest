import java.util.*;
class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
      
        if (i < 0) {
            return -1;
        }
        int j = length - 1;
        while (digits[i] >= digits[j]) {
            j--;
        }
        swap(digits, i, j);
        reverse(digits, i + 1, length - 1);
        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
}