// Output limit exceeded
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // 1, -2, 3, -2, 1, -2, 3, -2, ...
        Integer result = null;
        int tempSum = 0;
        for (int j=0; j<nums.length; j++) {
            for (int i=0; i<nums.length; i++) {
                tempSum = Math.max(tempSum + nums[(j+i)%nums.length], nums[(j+i)%nums.length]);
                if (result == null || result < tempSum) {
                    result = tempSum;
                }
                System.out.println(String.format("tempSum:%d, result:%d", tempSum, result));
            }
            tempSum = 0;
        }
        return result;
    }
}
