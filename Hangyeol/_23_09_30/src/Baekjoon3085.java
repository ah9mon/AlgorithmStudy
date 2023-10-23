import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3085 {
    // https://www.acmicpc.net/problem/3085

    private static int N;
    private static char[][] candies;
    private static int[] dx = new int[]{0, -1, 0, 1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        candies = new char[N][N];
        for (int i = 0; i < N; i++) {
            candies[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                dfs(x, y);
            }
        }
        System.out.println(max);



    }

    private static void dfs(int x, int y) {
        for (int dv = 0; dv < 4; dv++) {
            int nx = x + dx[dv];
            int ny = y + dy[dv];
            // 범위 안에 있고 인접한 사탕 종류 다르면
            if (isInRange(nx, ny) && candies[y][x] != candies[ny][nx]) {

                // 사탕 위치 바꾸고
                char temp = candies[y][x];
                candies[y][x] = candies[ny][nx];
                candies[ny][nx] = temp;

                // 몇개 먹을 수 있는지 확인
                checkMaxCandies();

                // 원상복구
                candies[ny][nx] = candies[y][x];
                candies[y][x] = temp;
            }
        }
    }

    private static void checkMaxCandies() {
        // 가로 확인
        for (int y = 0; y < N; y++) {
            int count = 1;
            char previousCandy = candies[y][0];
            for (int x = 1; x < N; x++) {
                if (previousCandy == candies[y][x]) {
                    count++;
                } else {
                    count = 1;
                    previousCandy = candies[y][x];
                }

                if (max < count) max = count;
            }
        }

        // 세로 확인
        for (int x = 0; x < N; x++) {
            int count = 1;
            char previousCandy = candies[0][x];
            for (int y = 1; y < N; y++) {
                if (previousCandy == candies[y][x]) {
                    count++;
                } else {
                    count = 1;
                    previousCandy = candies[y][x];
                }

                if (max < count) max = count;
            }
        }
    }

    private static boolean isInRange(int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            return true;
        }
        return false;
    }
}
