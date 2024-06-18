class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        int left = len - 2;
        while (left >= 0 && digits[left] >= digits[left + 1]) {
            left--;
        }
        if (left < 0) {
            return -1;
        }
        int right = len - 1;
        while (digits[left] >= digits[right]) {
            right--;
        }
        swap(digits, left, right);
        reverse(digits, left + 1, len - 1);
        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     public void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
}