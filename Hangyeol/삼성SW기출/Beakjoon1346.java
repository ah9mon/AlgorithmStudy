import java.util.*;
import java.io.*;


public class Beakjoon1346 {

    static class State {
        private int rx;
        private int ry;
        private int bx;
        private int by;
        private int moveCount;

        public State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.moveCount = count;
        }
    }

    private static int n;
    private static int m;
    private static char[][] graph;
    private static int[] red = new int[2];
    private static int[] blue = new int[2];
    private static int[] dx = new int[]{1, 0 , -1, 0};
    private static int[] dy = new int[]{0, 1, 0 , -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];

        for (int row = 0; row < n; row++) {
            String line = br.readLine();
            for (int col = 0; col < m; col++) {
                graph[row][col] = line.charAt(col);
                checkLocation(row, col);
            }
        }

        System.out.println(bfs(red, blue));

    }

    public static int bfs(int[] redStart, int[] blueStart) {
        Deque<State> q = new ArrayDeque();
        int[][][][] visited = new int[m][n][m][n];
        q.add(new State(redStart[0], redStart[1], blueStart[0], blueStart[1], 0));
        visited[redStart[0]][redStart[1]][blueStart[0]][blueStart[1]] = 1;

        while (!q.isEmpty()) {
            State state = q.pollFirst();

            for (int dv = 0; dv < 4; dv++) {
                if (move(q, state, visited, dv)) {
                    return state.moveCount + 1;
                }
            }
        }

        return -1;
    }

    private static boolean move(Deque q, State state, int[][][][] visited, int dv) {
        // 이동횟수 체크
        if (state.moveCount + 1 > 10) return false;

        // blue 벽까지 보내기
        int nbx = state.bx;
        int nby = state.by;
        while (graph[nby + dy[dv]][nbx + dx[dv]] != '#') {
            nbx += dx[dv];
            nby += dy[dv];
            if (graph[nby][nbx] == 'O') return false;
        }

        // red 벽까지 보내기
        int nrx = state.rx;
        int nry = state.ry;
        while (graph[nry + dy[dv]][nrx + dx[dv]] != '#') {
            nrx += dx[dv];
            nry += dy[dv];
            if (graph[nry][nrx] == 'O') return true;
        }

        // 위치 조정
        if (nrx == nbx && nry == nby) {
            if (dv == 0) { // 오른쪽방향
                if (checkOrder(state.rx, state.bx)) {
                    nbx -= 1;// 빨강이 오른쪽
                } else {
                    nrx -= 1;
                }
            } else if (dv == 1) { // 아래방향
                if (checkOrder(state.ry, state.by)) {
                    nby -= 1;// 빨강이 아래쪽
                } else {
                    nry -= 1;
                }
            } else if (dv == 2) { // 왼쪽방향
                if (checkOrder(state.rx, state.bx)) {
                    nrx += 1; // 빨강이 오른쪽
                } else {
                    nbx += 1;
                }
            } else { // 위 방향
                if (checkOrder(state.ry, state.by)) {
                    nry += 1;
                } else {
                    nby += 1;
                }
            }
        }

        if (visited[nrx][nry][nbx][nby] == 0) {
            q.add(new State(nrx, nry, nbx, nby, state.moveCount + 1));
            visited[nrx][nry][nbx][nby] = 1;
        }

        return false;
    }

    private static boolean checkOrder(int red, int blue) {
        if (red > blue) return true;
        return false;
    }

    private static void checkLocation(int row, int col) {
        if (graph[row][col] == 'R') {
            red[0] = col;
            red[1] = row;
        } else if (graph[row][col] ==  'B') {
            blue[0] = col;
            blue[1] = row;
        }
    }
}
