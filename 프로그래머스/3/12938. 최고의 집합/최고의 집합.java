class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int a = s/n;
        int b = s%n;
        
        if(a == 0) return new int[]{-1};
        
        for(int i = n-1; i >= 0; i--){
            answer[i] = a;
            if(b > 0){
                answer[i] += 1;
                b--;
            }
        }
        
        return answer;
    }
}