class Solution {
    public int solution(int[] box, int n) {
        int w = box[0]/n;
        int d = box[1]/n;
        int h = box[2]/n;
        return w*h*d;
    }
}