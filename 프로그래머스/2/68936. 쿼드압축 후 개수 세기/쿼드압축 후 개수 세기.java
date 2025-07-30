class Solution {
    private static class Count {
        private final int one;
        private final int zero;
        
        public Count(int one, int zero) {
            this.one = one;
            this.zero = zero;
        }
        
        public Count add(Count other) {
            return new Count(this.one+other.one, this.zero+other.zero);
        }
    }
    private Count count(int[][] arr, int y, int x, int size) {
        int h = size / 2;
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(arr[j][i] != arr[y][x]) {
                    return count(arr, y, x, h)
                            .add(count(arr, y+h, x, h))
                            .add(count(arr, y, x+h, h))
                            .add(count(arr, y+h, x+h, h));
                }
            }
        }
        if (arr[y][x] == 1) {
            return new Count(1, 0);
        }
        return new Count(0, 1);
    }
    public int[] solution(int[][] arr) {
        Count count = count(arr, 0, 0, arr.length);
        return new int[] {count.zero, count.one};
    }
}