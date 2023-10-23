import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1834 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        int i = 1;
        while (i < n) {
            sum += ((long) i * n) + i;
            i++;
        }
        System.out.println(sum);
    }
}
