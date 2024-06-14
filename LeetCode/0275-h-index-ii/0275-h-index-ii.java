class Solution {
    public int hIndex(int[] citations) {
        int hIdx = citations.length;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= hIdx) {
                return hIdx;
            }
            hIdx--;
        }
        return hIdx;
    }
}