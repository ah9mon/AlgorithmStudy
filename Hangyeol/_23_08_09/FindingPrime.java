import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class FindingPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rlt = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(Integer.parseInt(st.nextToken()))) {
                rlt++;
            }
        }
        System.out.println(rlt);
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false; // 1은 소수 아님

        int sqrt = (int) Math.sqrt(num);
        if (sqrt*sqrt == num) return false;

        for (int n = 2; n*n < num; n++) {
            if ((num % n) == 0) {
                return false; // 나누어 떨어지므로 소수 아님
            }
        }

        return true;
    }
}
