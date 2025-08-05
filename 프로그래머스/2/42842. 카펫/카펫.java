class Solution {
    public int[] solution(int brown, int yellow) {
        for(int h = 1; h <= yellow; h++) {
            if(yellow % h != 0) {
                continue;
            }
            if(2*(h+yellow/h)+4 == brown) {
                return new int[] {yellow/h+2, h+2};
            }
        }
        return null;
    }
}