import java.util.Arrays;
import java.util.Scanner;

/* [#1] 평균 study
https://www.acmicpc.net/problem/1546
* */
public class No1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int score[] = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        int max = Arrays.stream(score).max().getAsInt();

        double change[] = new double[n];
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            change[i] = (double) score[i] / max * 100;
            /*    change[i] = (double)(score[i] / max * 100 );*/
            /*    change[i] = (double)(score[i] / max ) * 100 ;*/
            sum += change[i];
        }

        System.out.println(sum / change.length);
    }
}

