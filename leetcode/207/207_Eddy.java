import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int[] num_of_pointing_to_me;
    private static ArrayList<Integer>[] edges;

    private static void init(int numCourses, int[][] prerequisites) {
        num_of_pointing_to_me = new int[numCourses];
        edges = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (edges[prerequisites[i][1]] == null) {
                edges[prerequisites[i][1]] = new ArrayList<>();
            }

            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            num_of_pointing_to_me[prerequisites[i][0]]++;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num_of_pointing_to_me.length; i++) {
            if (num_of_pointing_to_me[i] == 0 && edges[i] != null) {
                queue.add(i);
            }
        }

        int num_of_edges_left = prerequisites.length;
        int u, v;
        while (!queue.isEmpty()) {
            u = queue.poll();
            if (edges[u] == null) continue;
            for (int j = edges[u].size() - 1; j >= 0; j--) {
                v = edges[u].get(j);
                if (--num_of_pointing_to_me[v] == 0) {
                    queue.add(v);
                }
                edges[u].remove(j);
                num_of_edges_left--;
            }
        }

        return num_of_edges_left == 0;
    }
}
