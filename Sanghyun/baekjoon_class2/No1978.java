import java.util.Scanner;

/* [#1] 소수 찾기 study
https://www.acmicpc.net/problem/1978
* */
public class No1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int flag = 1;
            int num = sc.nextInt();
            for (int j = 1; j <= num; j++) {
                if (j != 1 && j != num && num % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1 && num > 1) cnt++;
        }
        System.out.println(cnt);
    }
}

