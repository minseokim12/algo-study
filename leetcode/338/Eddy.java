class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        if (n > 0) {
            ans[1] = 1;
            if (n > 1) {
                ans[2] = 1;
            }
        }

        int exp = 2;
        for (int i = 3; i <= n; i++) {
            if (i == exp * 2) {
                exp *= 2;
                ans[i] = 1;
            } else {
                ans[i] = ans[exp] + ans[i - exp];
            }
        }
        return ans;
    }
}
