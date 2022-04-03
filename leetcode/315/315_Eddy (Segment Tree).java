import java.util.ArrayList;
import java.util.List;

class Solution {

    private static class SegmentTree {
        int len_half;
        int[] count;

        SegmentTree(int N) {
            len_half = 2;
            while (len_half < N) {
                len_half *= 2;
            }
            count = new int[len_half * 2];
        }

        void update(int idx) {
            idx = len_half + idx;
            while (idx > 0) {
                count[idx]++;
                idx /= 2;
            }
        }

        int query(int idx_from, int idx_to) {
            int ans = 0;
            idx_from = len_half + idx_from;
            idx_to = len_half + idx_to;

            while (idx_from <= idx_to) {
                if (idx_from % 2 != 0) {
                    ans += count[idx_from];
                    idx_from = idx_from / 2 + 1;
                } else {
                    idx_from = idx_from / 2;
                }

                if (idx_to % 2 != 1) {
                    ans += count[idx_to];
                    idx_to = idx_to / 2 - 1;
                } else {
                    idx_to = idx_to / 2;
                }
            }
            return ans;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        SegmentTree segTree = new SegmentTree(20001);

        int val;
        for (int i = nums.length - 1; i >= 0; i--) {
            val = nums[i] + 10000;
            nums[i] = segTree.query(0, val - 1);
            segTree.update(val);
        }

        ArrayList<Integer> ans = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }
        return ans;
    }
}
