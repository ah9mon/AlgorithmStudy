import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieTitle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 665;
        while (n > 0) {
            num++;
            if (Integer.toString(num).contains("666")) {
                n --;
            }
        }
        System.out.println(num);
    }
}
