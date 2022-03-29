import java.util.ArrayList;

class Solution {

    public static int longestConsecutive(int[] nums) {

        ArrayList<Integer>[] num_mod_100001 = new ArrayList[20000];
        for (int i = 0; i < 20000; i++) {
            num_mod_100001[i] = new ArrayList<>();
        }
        for (int n : nums) {
            num_mod_100001[(n + 1000000000) / 100001].add(((n + 1000000000) % 100001) + 1);
        }

        int[] longest_length_from_left = new int[100001 + 2];
        int[] longest_length_from_right = new int[100001 + 2];
        int length_from_left_to_100000 = 0;
        int ans = 0;
        for (int i = 0; i < 20000; i++) {
            for (int n : num_mod_100001[i]) {
                if (longest_length_from_left[n] != 0) continue;

                longest_length_from_left[n] = longest_length_from_right[n] = 1;

                int length = longest_length_from_left[n - 1] + 1 + longest_length_from_right[n + 1];
                longest_length_from_right[n - longest_length_from_left[n - 1]] = length;
                longest_length_from_left[n + longest_length_from_right[n + 1]] = length;

                ans = Math.max(ans, length);
            }
            ans = Math.max(ans, length_from_left_to_100000 + longest_length_from_right[1]);
            length_from_left_to_100000 = longest_length_from_left[100001];
            for (int n : num_mod_100001[i]) {
                longest_length_from_left[n] = longest_length_from_right[n] = 0;
            }
        }

        return ans;
    }
}
