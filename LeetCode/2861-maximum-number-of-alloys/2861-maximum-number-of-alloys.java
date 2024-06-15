class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int answer = 0;
        int max = Collections.max(stock);
        for(int i = 0; i < k; i++) {
            int left = 0;
            int right = budget + max;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(calculate(n, composition.get(i), stock, cost, mid, budget)) {
                    left = mid + 1;
                    answer = Math.max(answer, mid);
                } else {
                    right = mid - 1;
                }
            }
        }
        return answer;
    }
    public boolean calculate(int n, List<Integer> com, List<Integer> stock, List<Integer> cost, long mid, int budget) {
        long sum = 0;
        for(int i = 0; i < n; i++) {
            long count = mid * com.get(i);
            if(stock.get(i) < count) {
                sum += cost.get(i) * (count - stock.get(i));
            }
            if(sum > budget) {
                return false;
            }
        }
        return true;
    }
}