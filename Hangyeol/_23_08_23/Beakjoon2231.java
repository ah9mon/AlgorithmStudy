import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int num = 0; num < n; num++) {
            if (n == getDecomposeSum(num)) {
                System.out.println(num);
                return;
            }
        }
        System.out.println(0);
    }

    private static int getDecomposeSum (int num) {
        int sum = num;
        String numString = Integer.toString(num);
        int len = numString.length();
        for (int index = 0; index < len; index++) {
            sum += Character.getNumericValue(numString.charAt(index));
        }
        return sum;
    }
}