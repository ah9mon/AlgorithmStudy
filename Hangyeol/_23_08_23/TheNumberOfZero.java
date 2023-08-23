import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TheNumberOfZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        BigInteger nFactorial = getFactorial(n);
        String nFactorialToString = nFactorial.toString();
        for (int index = nFactorialToString.length() - 1 ; index >= 0 ; index--) {
            if (nFactorialToString.charAt(index) != '0') {
                break;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }

    private static BigInteger getFactorial (int n) {
        BigInteger rlt = BigInteger.ONE;
        for (int num = 1; num <= n; num++) {
            rlt = rlt.multiply(BigInteger.valueOf(num));
        }
        return rlt;
    }
}
