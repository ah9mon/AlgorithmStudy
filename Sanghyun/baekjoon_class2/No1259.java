import java.util.Scanner;

/* [#1] 팰린드롬수 study
https://www.acmicpc.net/problem/1259
* */
public class No1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        while (!num.equals("0")) {
            int lt = 0;
            int rt = num.length() - 1;
            String answer = "yes";

            while (lt < rt) {
                if (num.charAt(lt) != num.charAt(rt)) {
                    answer = "no";
                    break;
                }
                lt++;
                rt--;
            }
            System.out.println(answer);
            num = sc.next();
        }

    }
}

