import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        // graph 초기화
        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for (int k = 1; k < n + 1; k++) {
            graph[k] = new LinkedList<>();
        }

        // Link 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(link.nextToken());
            int node2 = Integer.parseInt(link.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        search(graph, n, startNode, true); // true -> DFS
        search(graph, n, startNode, false);// false -> BFS

    }

    private static void search(LinkedList<Integer>[] graph,int n, int startNode, boolean isDfs) {
        int[] visited = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        deque.add(startNode);
        while (!deque.isEmpty()) {
            int node;

            if (isDfs) {
                node = deque.pollLast();
            } else {
                node = deque.pollFirst();
            }

            if (visited[node] == 1) continue;
            visited[node] = 1;
            sb.append(node).append(" ");

            LinkedList<Integer> linkedNodes = graph[node];

            if (isDfs) {
                Collections.sort(linkedNodes, Comparator.reverseOrder());;
            } else {
                Collections.sort(linkedNodes);
            }

            for (Integer linkedNode : linkedNodes) {
                // 방문 처리
                if (visited[linkedNode] == 0) {
                    deque.add(linkedNode);
                }
            }
        }
        System.out.println(sb);
    }
}