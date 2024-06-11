class Solution {
    public int first, second;
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] answer = new int[2];
        first = 0;
        second = 0;
        double left = 0;
        double right = 1;
        while(left <= right) {
            double mid = (left + right) / 2;
            if(calculate(arr, mid) == k) {
                answer[0] = arr[first];
                answer[1] = arr[second];
                break;
            }
            else if(calculate(arr, mid) < k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return answer;
    }
    public int calculate(int[] arr, double fraction) {
        int idx = 0;
        int j = 1;
        double max = 0;
        for(int i = 0; i < arr.length; i++) {
            while(j < arr.length && arr[i] / (double)arr[j] >= fraction) {
                j++;
            }
            idx += arr.length - j;
            if(j < arr.length &&  max < arr[i] / (double)arr[j]) {
                max =  arr[i] / (double)arr[j];
                first = i;
                second = j;
            }
        }
        return idx;
    }
}