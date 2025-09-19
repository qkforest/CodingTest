class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        int count = 0;
        for(int a: arr){
            if(a == 1 && count >= idx){
                answer = count;
                break;
            } else
                count += 1;
        }
        return (answer > -1) ? answer : -1;
    }
}