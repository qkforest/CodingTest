class Solution {
    public int solution(int[] a) {
        int answer = -1;
        int len = a.length;
        int[] count = new int[len];
        for(int n : a) {
            count[n]++;
        }
        for(int i = 0; i < len; i++) {
            if(count[i] <= answer) {
                continue;
            }
            int temp = 0;
            for(int j = 0; j < len - 1; j++) {
                if(a[j] != a[j+1] && (i == a[j] || i == a[j+1])) {
                    temp++;
                    j++;
                }
            }
            answer = Math.max(temp, answer);
        }
        return answer * 2;
    }
}