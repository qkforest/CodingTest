class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        long start = 0, first = 0, count = 0, add = 0;
        int idx = 0;
        if(left % n == 0)
            start = left;
        else
            start = left - (left % n);
        for(long i = start; i <= right; i++){
            if(i % n == 0){
                first = i/n + 1;
                count = 1;
                add = 1;
            }
            if(count <= first){
                if(i >= left){
                    answer[idx] = (int)first;
                    idx++;
                }
                count++;
            } else{
                if(i >= left){
                    answer[idx] = (int)(first + add);
                    idx++;
                }
                add++;
            }
        }  
        return answer;
    }
}