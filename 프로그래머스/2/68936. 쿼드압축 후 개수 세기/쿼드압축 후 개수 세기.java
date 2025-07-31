class Solution {
    private boolean check(int y, int x, int size, int[][] arr) {
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(arr[i][j] != arr[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }
    private void count(int y, int x, int size, int[][] arr, int[] answer) {
        int h = size / 2;
        if(check(y, x, size, arr)) {
            answer[arr[y][x]]++;
            return;
        }
        count(y, x, h, arr, answer);
        count(y+h, x, h, arr, answer);
        count(y, x+h, h, arr, answer);
        count(y+h, x+h, h, arr, answer);
    }
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        count(0, 0, arr.length, arr, answer);
        return answer;
    }
}