import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/* [#1] 이항 계수 1 study
n개의 원소중 k개를 순서에 상관없이 뽑는 조합의 가짓수
https://www.acmicpc.net/problem/11050
* */
public class No11050 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];

        System.out.println(nCr(n, k));
    }

    static int nCr(int n, int k) {
        if (dp[n][k] > 0)
            return dp[n][k];

        if (n == k || k == 0)
            return 1; // 파스칼 삼각형

        return dp[n][k] = nCr(n - 1, k - 1) + nCr(n - 1, k);
    }
}

