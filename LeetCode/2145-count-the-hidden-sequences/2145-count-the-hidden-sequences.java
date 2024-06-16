class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int[] num = new int[differences.length + 1];
        for(int i = 1; i < num.length; i++) {
            num[i] = num[i-1] + differences[i-1];
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        min = lower - min;
        max = upper - max;
        if(min > max) {
            return 0;
        }
        int count = Math.min(max, upper) - Math.max(min, lower) + 1;
        if(count > 0) {
            return count;
        }
        return 0;
    }
}