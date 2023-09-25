import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Beakjoon2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer>[] graph = new ArrayDeque[n + 1];

        int numberOfLinks = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfLinks; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (graph[node1] == null) graph[node1] = new ArrayDeque<>();
            if (graph[node2] == null) graph[node2] = new ArrayDeque<>();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        if (numberOfLinks > 0) {
            System.out.println(bfs(n, graph));
        } else {
            System.out.println(0);
        }
    }

    private static int bfs(int n, ArrayDeque<Integer>[] graph) {
        int count = 0;
        int[] visited = new int[n + 1];
        visited[1] = 1;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);

        while (!deque.isEmpty()) {
            int node = deque.pollFirst();
            for (Integer nextNode : graph[node]) {
                if (visited[nextNode] == 0) {
                    deque.add(nextNode);
                    visited[nextNode] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}
