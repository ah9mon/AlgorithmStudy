import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501 {

    private static int[][] schedule;
    private static int N;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(max);

    }

    private static void dfs(int revenue, int day) {
        if (day == N) {
            if (max < revenue) max = revenue;
        } else if (day < N){
            dfs(revenue + schedule[day][1], day + schedule[day][0]);
            dfs(revenue, day + 1);
        }
    }
}
