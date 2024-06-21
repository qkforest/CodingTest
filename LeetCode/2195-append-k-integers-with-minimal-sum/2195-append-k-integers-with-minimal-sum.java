class Solution {
    public long minimalKSum(int[] nums, int k) {
        long answer = 0;
        int len = nums.length;
        long pre = 0;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            long diff = nums[i] - 1 - pre;
            if(diff > 0) {
                if(diff < k) {
                    answer += diff * 0.5 * (nums[i] + pre);
                    k -= diff;
                }
                else {
                    answer += k *  0.5 * (pre + k + pre + 1);
                    k = 0;
                }
            }
            if(k == 0) {
                break;
            }
            pre = nums[i];
        }
        if(k > 0) {
            answer += k *  0.5 * (nums[len-1] + k + nums[len-1] + 1);
        }
        return answer;
    }
}