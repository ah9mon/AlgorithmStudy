import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Beakjoon15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(getHash(n,str));
    }

    private static BigInteger getHash(int n, String str) {
        BigInteger hash = BigInteger.ZERO;
        BigInteger r = BigInteger.valueOf(31);
        for (int index = 0; index < n; index++) {
            BigInteger ri = r.pow(index);
            BigInteger ari = ri.multiply(BigInteger.valueOf((int) str.charAt(index) - 96));
            hash = hash.add(ari);
        }
        return hash;
    }
}
