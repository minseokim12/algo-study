import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://www.quora.com/What-are-the-specifics-in-implementing-an-O-N-log-N-Lowest-Common-Ancestor-algorithm
class Main {

    private static int N, log_N;
    private static ArrayList<Integer>[] edges;
    private static boolean[] visited;
    private static int[][] parents;
    private static int[] depths;

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < N - 1; i++) {
            String[] tmp = br.readLine().split(" ");
            u = Integer.parseInt(tmp[0]);
            v = Integer.parseInt(tmp[1]);

            edges[u].add(v);
            edges[v].add(u);
        }

        log_N = 2 + (int) (Math.log(N) / Math.log(2));
        visited = new boolean[N + 1];
        parents = new int[N + 1][log_N];
        depths = new int[N + 1];
    }

    private static void make_parents(int u) {
        for (int v : edges[u]) {
            if (visited[v]) continue;
            visited[v] = true;

            depths[v] = depths[u] + 1;
            parents[v][0] = u;
            // parents[v][j] means '2^j's grandParent of v.
            // (ex. parent[3][4] means 16's grandParent of node 3)
            for (int j = 1; j < log_N; j++) {
                if (parents[v][j - 1] == 0) break;
                parents[v][j] = parents[parents[v][j - 1]][j - 1];
            }
            make_parents(v);
        }
    }

    private static int find_lca(int u, int v) {
        if (depths[u] > depths[v]) {
            u = make_depth_equal(u, depths[v]);
        } else {
            v = make_depth_equal(v, depths[u]);
        }
        while (u != v) {
            for (int j = 1; j < log_N; j++) {
                if (parents[u][j] == parents[v][j]) {
                    u = parents[u][j - 1];
                    v = parents[v][j - 1];
                    break;
                }
            }
        }
        return u;
    }

    private static int make_depth_equal(int u, int depth) {
        while (depths[u] > depth) {
            for (int j = 1; j < log_N; j++) {
                if (depths[parents[u][j]] <= depth) {
                    u = parents[u][j - 1];
                    break;
                }
            }
        }
        return u;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init(br);

        visited[1] = true;
        make_parents(1);

        int M = Integer.parseInt(br.readLine());
        int u, v;
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            u = Integer.parseInt(tmp[0]);
            v = Integer.parseInt(tmp[1]);

            System.out.println(find_lca(u, v));
        }

    }
}
