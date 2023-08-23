import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IceCream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<char[]> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(br.readLine().toCharArray());
        }

        int count = 0;
        int[][] visited = new int[n][m];
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < m; row++) {
                if (graph.get(col)[row] == '0' && visited[col][row] == 0) {
                    bfs(graph,visited,row,col,n,m);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs(ArrayList<char[]> graph, int[][] visited,int startX, int startY, int n, int m) {
        int[] dx = {1, -1 ,0 , 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        visited[startY][startX] = 1;

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            for (int index = 0; index < 4; index++) {
                int nx = coordinate[0] + dx[index];
                int ny = coordinate[1] + dy[index];
                if (checkRange(nx,ny,n,m) && graph.get(ny)[nx] == '0' && visited[ny][nx] == 0) {
                    queue.add(new int[] {nx, ny});
                    visited[ny][nx] = 1;
                }
            }
        }
    }

    private static boolean checkRange(int x, int y, int n, int m) {
        if (0 <= x && m > x && 0 <= y && n > y) {
            return true;
        }
        return false;
    }
}
