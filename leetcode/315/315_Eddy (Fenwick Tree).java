import java.util.ArrayList;
import java.util.List;

class Solution {

    class FenwickTree {
        int len;
        int[] count;

        FenwickTree(int N) {
            len = 2;
            while (len < N) {
                len *= 2;
            }
            count = new int[len + 1];
        }

        void update(int idx) {
            while (idx <= len) {
                count[idx]++;
                idx += (idx & -idx);
            }
        }

        int query(int idx) {
            int ans = 0;
            while (idx > 0) {
                ans += count[idx];
                idx -= (idx & -idx);
            }
            return ans;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        FenwickTree fenTree = new FenwickTree(20001);

        int val;
        for (int i = nums.length - 1; i >= 0; i--) {
            val = nums[i] + 10001;
            nums[i] = fenTree.query(val - 1);
            fenTree.update(val);
        }

        ArrayList<Integer> ans = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }
        return ans;
    }
}
