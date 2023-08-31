import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] rlt = new int[tc];
        int maxNum = 0;
        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());
            rlt[i] = num;
            if (num > maxNum) maxNum = num;
        }

        int[][] dp = new int[maxNum + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        if (maxNum > 0) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }

        for (int index = 2; index <= maxNum; index++) {
            dp[index][0] = dp[index - 1][0] + dp[index - 2][0];
            dp[index][1] = dp[index - 1][1] + dp[index - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < tc; index++) {
            int[] tcResult = dp[rlt[index]];
            sb.append(tcResult[0] + " " + tcResult[1] + "\n");
        }

        System.out.println(sb);
    }
}
