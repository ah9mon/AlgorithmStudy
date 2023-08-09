import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) return;
            checkPalindromes(num);
        }
    }

    private static void checkPalindromes(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        for (int index = 0; index < arr.length/2; index++) {
            if (arr[index] != arr[len - index - 1]) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
