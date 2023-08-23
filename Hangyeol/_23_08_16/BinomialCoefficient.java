import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinomialCoefficient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] cache = new int[n+1][n+1];
        checkBinomialCoefficient(cache, n);
        System.out.println(cache[n][k]);
    }

    private static void checkBinomialCoefficient(int[][] cache, int n) {

        // 다 뽑거나 안뽑는 경우의 수는 1
        for (int index = 0; index < n + 1; index++ ) {
            cache[index][0] = 1;
            cache[index][index] = 1;
        }

        for (int row = 1; row < n + 1; row++) { // 시도
            for (int col = 1; col < row ; col++) { // 고른 수
                cache[row][col] = cache[row - 1][col - 1] + cache[row - 1][col];
            }
        }
    }
}
