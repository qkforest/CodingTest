class Solution {
    public int[] solution(int brown, int yellow) {
        for(int w = 3; w <= 5000; w++) {
            for(int h = 3; h <= w; h++) {
                int b = (w+h-2) * 2;
                if(b == brown && w*h - b == yellow) {
                    return new int[]{w, h};
                } 
            }
        }
        return null;
    }
}