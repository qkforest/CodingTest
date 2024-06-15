class Solution {
    public int hIndex(int[] citations) {
        int hIdx = 0;
        int left = 0;
        int right = citations.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(citations[mid] >= citations.length - mid) {
                hIdx = citations.length - mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }        
        return hIdx;
    }
}