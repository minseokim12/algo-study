class Solution {
    public static String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        if (arr.length == k) return "0";

        Queue<Integer>[] idx_of_digits = new Queue[10];
        for (int i = 0; i < idx_of_digits.length; i++) {
            idx_of_digits[i] = new LinkedList<>();
        }

        int last_touch = -1;
        for (int i = 0; i < arr.length; i++) {
            idx_of_digits[arr[i] - '0'].add(i);

            if (i - last_touch == k + 1) {
                int idx = get_Smallest_idx(idx_of_digits);
                for (int j = last_touch + 1; j < idx; j++) {
                    arr[j] = 0;
                }
                k -= idx - last_touch - 1;
                last_touch = idx;
                if (arr.length - 1 - last_touch == k) {
                    for (int j = last_touch + 1; j < arr.length; j++) {
                        arr[j] = 0;
                    }
                }
                remove_Smaller_idx(idx_of_digits, idx);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean nonZero_start = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (arr[i] == '0' && nonZero_start) {
                    sb.append(arr[i]);
                }
                if (arr[i] != '0') {
                    sb.append(arr[i]);
                    nonZero_start = true;
                }
            }
        }

        if (!nonZero_start) {
            sb.append('0');
        }

        return sb.toString();
    }

    private static int get_Smallest_idx(Queue<Integer>[] idx_of_digits) {
        for (int i = 0; i < idx_of_digits.length; i++) {
            if (!idx_of_digits[i].isEmpty()) return idx_of_digits[i].poll();
        }

        return -1; // not happen
    }

    private static void remove_Smaller_idx(Queue<Integer>[] idx_of_digits, int idx) {
        for (int i = 0; i < idx_of_digits.length; i++) {
            while (!idx_of_digits[i].isEmpty() && idx_of_digits[i].peek() < idx) {
                idx_of_digits[i].poll();
            }
        }
    }
}
