class Solution {
    public long continuousSubarrays(int[] nums) {
        long answer = 0;
        int i = 0;
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int j = 0; j < len; j++) {
            map.merge(nums[j], 1, Integer::sum);
            while (map.lastKey() - map.firstKey()  > 2) {
                map.merge(nums[i], -1, Integer::sum);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            answer += j - i + 1;
        }
        return answer;
    }
}