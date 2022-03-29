class Solution {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int cur_ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur_ans < 0) {
                cur_ans = nums[i];
            } else {
                cur_ans += nums[i];
            }
            ans = Math.max(ans, cur_ans);
        }
        return ans;
    }
}
