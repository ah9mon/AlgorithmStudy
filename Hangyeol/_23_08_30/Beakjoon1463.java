import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        for (int n = 1; n <= x; n++) {
            int count = dp[n];
            if (2*n <= x && (dp[2*n] > count + 1 || dp[2*n] == 0)) {
                dp[2*n] = count + 1;
            }

            if (3*n <= x && (dp[3*n] > count + 1 || dp[3*n] == 0)) {
                dp[3*n] = count + 1;
            }

            if (n+1 <= x && (dp[n+1] > count + 1 || dp[n+1] == 0)) {
                dp[n+1] = count + 1;
            }
        }

        System.out.println(dp[x]);
    }
}
