import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {

    private static int[] dx = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int I = Integer.parseInt(br.readLine());
            int[][] visited = new int[I][I];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st1.nextToken());
            int startY = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st2.nextToken());
            int endY = Integer.parseInt(st2.nextToken());

            bfs(startX, startY, visited, I);


            sb.append((visited[endY][endX] - 1)).append("\n");
        }

        System.out.println(sb);

    }

    private static boolean isInRange(int x, int y, int I) {
        if (0 <= x && x < I && 0 <= y && y < I) {
            return true;
        }
        return false;
    }

    private static void bfs(int startX, int startY, int[][] visited, int I) {
        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{startX, startY});
        visited[startY][startX] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInRange(nx, ny, I) && visited[ny][nx] == 0) {
                    queue.add(new int[]{nx, ny});
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }
    }
}
