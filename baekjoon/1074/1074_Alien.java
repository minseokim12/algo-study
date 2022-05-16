import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1074
 */
public class Main {

    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int length = (int) Math.pow(2, N); //한 변의 갯수
        find(length, r, c);
        System.out.println(result);
    }

    public static void find(int length, int r, int c){
        if (length == 1) {
            return;
        }
        int half = length / 2;
        int sizePerDivided = length * length / 4 ;

        if (r < half) {
            //1사분면
            if (c < half) {
                find(half, r, c);
            } else {
            //2사분면
                result += sizePerDivided;
                find(half, r, c - half);
            }
        } else {
            //3사분면
            if (c < half) {
                result += sizePerDivided * 2;
                find(half, r - half, c);
            } else {
            //4사분면
                result += sizePerDivided * 3;
                find(half, r - half, c - half);
            }
        }
    }
}
