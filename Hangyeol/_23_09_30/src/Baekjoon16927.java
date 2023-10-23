import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16927 {

    private static int N;
    private static int M;
    private static int R;
    private static String[][] graph;
    private static String[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken());
        graph = new String[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = st2.nextToken();
            }
        }

        for (int row = 0; row < N / 2; row++) {
            if (row >= M / 2) break;
            int count = 0;
            while (count < R) {
                String temp1 = graph[row][row];
                String temp2 = graph[(N-1) - row][row];
                String temp3 = graph[(N-1) - row][(M-1) - row];
                String temp4 = graph[row][(M-1) - row];

                // 왼쪽
                moveV(row, row, 1);
                graph[row + 1][row] = temp1;

                // 아래
                moveH((N-1) - row, row, 1);
                graph[(N-1) - row][row + 1] = temp2;

                // 오른쪽
                moveV(row, (M-1) - row, -1);
                graph[(N-1) - row - 1][(M-1) - row] = temp3;

                // 위
                moveH(row, row, -1);
                graph[row][(M-1) - row - 1] = temp4;

                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j != (M-1)) {
                    sb.append(graph[i][j] + " ");
                } else {
                    sb.append(graph[i][j]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static void moveV(int row, int col, int v) {
        int first = row;
        int last = (N-1) - row;
        if (v == 1) {
            for (int i = last; i > first + 1; i--) {
                graph[i][col] = graph[i - 1][col];
            }
        } else {
            for (int i = first; i < last - 1; i++) {
                graph[i][col] = graph[i + 1][col];
            }
        }
    }

    private static void moveH(int row, int col, int v) {
        int first = col;
        int last = (M-1) - col;
        if (v == 1) {
            for (int i = last; i > first + 1; i--) {
                graph[row][i] = graph[row][i - 1];
            }
        } else {
            for (int i = first; i < last - 1; i++) {
                graph[row][i] = graph[row][i + 1];
            }
        }
    }
}
