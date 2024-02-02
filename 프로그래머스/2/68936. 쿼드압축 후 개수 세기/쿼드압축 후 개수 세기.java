class Solution {
    public boolean check(int r, int c, int size, int[][] arr){
        for(int i = r; i < r+size; i++){
             for(int j = c; j < c+size; j++){
                 if(arr[r][c] != arr[i][j]) return false;
             }
        }
        return true;
    }
    public void dc(int r, int c, int size, int[][] arr, int[] answer){
        if(check(r, c, size, arr)){
            answer[arr[r][c]]++;
            return;
        }
        dc(r, c, size/2, arr, answer);
        dc(r, c+size/2, size/2, arr, answer);
        dc(r+size/2, c, size/2, arr, answer);
        dc(r+size/2, c+size/2, size/2, arr, answer);
        
        return;
    }
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        dc(0, 0, arr.length, arr, answer);
        return answer;
    }
}