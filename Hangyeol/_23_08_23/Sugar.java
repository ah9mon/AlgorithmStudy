import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sugar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }

        if (n % 5 == 3) {
            System.out.println(n / 5 + 1);
            return;
        }

        checkMinEa(n);
    }

    private static void checkMinEa (int n) {
        int theNumberOfFive = n / 5 - 1;
        while (theNumberOfFive >= 0) {
            int rest = n - theNumberOfFive * 5;
            if (rest % 3 == 0) {
                System.out.println(theNumberOfFive + rest / 3);
                return;
            } else {
                theNumberOfFive --;
            }
        }
        System.out.println(-1);
    }
}
