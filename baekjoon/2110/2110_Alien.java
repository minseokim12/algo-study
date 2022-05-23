package wifi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2110
 */
public class Main {

    private static int N = 0;
    private static int C = 0;
    private static int result = 0;
    private static int[] house = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int [N];
        for (int i = 0; i < N; i ++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        find();
        System.out.println(result);
    }

    public static void find(){
        int start = 0;
        int end = house[N - 1] - house[0];

        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = 1;
            int previous = house[0];
            for (int i = 1; i < N; i++) {
                if (house[i] - previous >= mid) {
                    cnt++;
                    previous = house[i];
                }
            }

            if (cnt < C) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }
    }
}
