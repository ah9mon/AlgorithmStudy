import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14889 {

    private static int N;
    private static int[][] ABILITY;
    private static int[] visited;
    private static int min = 20 * 20 * 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ABILITY = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ABILITY[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new int[N];
        dfs(0, 0);
        System.out.println(min);

    }

    private static void dfs(int count, int index) {
        if (count == N / 2) {
            int aTeamAbility = 0;
            int bTeamAbility = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < N; j++) {
                        if (visited[j] == 1) aTeamAbility += ABILITY[i][j];
                    }
                } else {
                    for (int k = 0; k < N; k++) {
                        if (visited[k] == 0) bTeamAbility += ABILITY[i][k];
                    }
                }
            }

            int gap = Math.abs(aTeamAbility - bTeamAbility);

            if (min > gap) min = gap;
        } else if (index == N) {
            return;
        } else {
            // index 번째 선수 합류
            visited[index] = 1;
            dfs(count + 1, index + 1);

            // index 번째 선수 합류 안함
            visited[index] = 0;
            dfs(count, index + 1);
        }
    }
}
