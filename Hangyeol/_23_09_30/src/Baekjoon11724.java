import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon11724 {

    private static int[] visited;
    private static ArrayList<Integer>[] graph;
    private static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int nodesSize = Integer.parseInt(st1.nextToken());
        int linkSize = Integer.parseInt(st1.nextToken());

        visited = new int[nodesSize + 1];
        graph = new ArrayList[nodesSize + 1];
        for (int i = 0; i <= nodesSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < linkSize; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st2.nextToken());
            int node2 = Integer.parseInt(st2.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int startNode = 1; startNode <= nodesSize; startNode++) {
            if (visited[startNode] == 0) bfs(startNode);
        }

        System.out.println(count);
    }

    private static void bfs(int startNode) {
        Deque<Integer> queue = new ArrayDeque();
        queue.add(startNode);
        visited[startNode] = 1;

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            for (int nextNode : graph[node]) {
                if (visited[nextNode] == 0) {
                    queue.add(nextNode);
                    visited[nextNode] = 1;
                }
            }
        }

        count++;
    }
}
