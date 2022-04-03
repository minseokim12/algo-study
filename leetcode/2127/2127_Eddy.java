class Solution {
    private int N;
    private int[] edges;
    private int[] touched;

    private int[] visited_time;
    private int[] idx_to_circle;
    private int[] length_to_circle;
    private int[] max_length_to_this;
    private int time, start_time, start_circle_time;

    int max_circle, line_sum;

    private void touch(int i) {
        int current_time = ++time;
        visited_time[i] = current_time;
        if (visited_time[edges[i]] >= start_time) {
            start_circle_time = visited_time[edges[i]];
            max_circle = Math.max(max_circle, time - start_circle_time + 1);
        }

        if (visited_time[edges[i]] == 0) {
            touch(edges[i]);
        }

        if (start_circle_time <= current_time) {
            idx_to_circle[i] = i;
        } else {
            idx_to_circle[i] = idx_to_circle[edges[i]];
            length_to_circle[i] = length_to_circle[edges[i]] + 1;
            max_length_to_this[idx_to_circle[i]] = Math.max(max_length_to_this[idx_to_circle[i]], length_to_circle[i]);
        }
    }

    public int maximumInvitations(int[] favorite) {
        N = favorite.length;
        touched = new int[N];
        for (int i = 0; i < N; i++) {
            touched[favorite[i]]++;
        }

        edges = favorite;
        visited_time = new int[N];
        idx_to_circle = new int[N];
        length_to_circle = new int[N];
        max_length_to_this = new int[N];
        for (int i = 0; i < N; i++) {
            if (touched[i] == 0) {
                start_time = time + 1;
                start_circle_time = 987654321;
                touch(i);
            }
        }
        for (int i = 0; i < N; i++) {
            if (visited_time[i] == 0) {
                start_time = time + 1;
                start_circle_time = 987654321;
                touch(i);
            }
        }
        for (int i = 0; i < N; i++) {
            if (edges[edges[i]] == i && i < edges[i]) {
                line_sum += max_length_to_this[i] + 2 + max_length_to_this[edges[i]];
            }
        }
        return Math.max(max_circle, line_sum);
    }
}
