import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1629
 */
public class Multiply {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(power(a, b, c));
    }
    // (a*b)%c = (a%c * b%c) % c
    private static long power(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long tmp = power(a, b / 2, c);

        /** (temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
         = (((temp * temp % C) % C) * (A % C)) % C 	// (temp * temp % C) = (temp * temp % C) % C
         = ((temp * temp % C) * A) % C
         */
        if (b % 2 == 1) {
            return tmp * tmp % c *  a % c ;
        } else {
            return tmp * tmp % c;
        }
    }

}
