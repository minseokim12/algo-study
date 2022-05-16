import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    // inOrder =    L Root R
    // postOrder =  L R Root
    // preOrder =   Root L R

    private static int N;
    private static int[] inOrder;
    private static int[] inOrder_idx;
    private static int[] postOrder;
    private static int[] postOrder_idx;

    private static void preOrder(int i_from, int i_to, int p_from, int p_to) {
        int root = postOrder[p_to];
        int i_root = inOrder_idx[root];

        System.out.print(root + " ");
        if (i_from < i_root) {
            preOrder(i_from, i_root - 1, p_from, p_from + (i_root - 1 - i_from));
        }
        if (i_root < i_to) {
            preOrder(i_root + 1, i_to, p_to - (i_to - i_root), p_to - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inOrder = new int[N];
        inOrder_idx = new int[N + 1];
        postOrder = new int[N];
        postOrder_idx = new int[N + 1];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(s[i]);
            inOrder_idx[inOrder[i]] = i;
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(s[i]);
            postOrder_idx[postOrder[i]] = i;
        }

        preOrder(0, N - 1, 0, N - 1);
    }
}
