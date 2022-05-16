import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static int N;
    private static int[] height;

    private static int divideAndConquer(int from, int to) {
        if (from == to) return height[from];

        int mid = (from + to) / 2;
        int tmp_ans = 0;
        int tmp_height = height[mid];
        int tmp_from = mid;
        int tmp_to = mid;
        while (true) {
            tmp_ans = Math.max(tmp_ans, (tmp_to - tmp_from + 1) * tmp_height);

            if (height[tmp_from - 1] < height[tmp_to + 1] && tmp_to < to) {
                tmp_to++;
            } else if (height[tmp_from - 1] > height[tmp_to + 1] && from < tmp_from) {
                tmp_from--;
            } else {
                if (tmp_to < to) {
                    tmp_to++;
                } else if (from < tmp_from) {
                    tmp_from--;
                } else {
                    break;
                }
            }

            tmp_height = Math.min(tmp_height, Math.min(height[tmp_from], height[tmp_to]));
        }

        return Math.max(tmp_ans, Math.max(divideAndConquer(from, mid), divideAndConquer(mid + 1, to)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        height = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(divideAndConquer(1, N));
    }
}
