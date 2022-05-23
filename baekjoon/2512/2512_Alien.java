package budget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2512
 */
public class Main {

    private static int N = 0;
    private static int M = 0;
    private static int sum = 0;
    private static int result = 0;
    private static int[] budget = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        budget = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }
        M =  Integer.parseInt(br.readLine());

        Arrays.sort(budget);
        find();
        System.out.println(result);
    }

    public static void find(){
        if (sum <= M) {
            result = budget[N - 1];
            return;
        }
        int start = 0;
        int end = M;

        while(start <= end) {
            int temp = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (budget[i] <= mid) {
                    temp += budget[i];
                } else {
                    temp += mid;
                }
            }

            if (temp > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }
    }
}
