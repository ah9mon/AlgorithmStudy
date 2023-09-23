import java.util.*;
import java.io.*;

public class Baekjoon13458 {

    private static int N;
    private static int[] A;
    private static int B;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
        }


        StringTokenizer st2 = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st2.nextToken());
        C = Integer.parseInt(st2.nextToken());

        Long count = 0L;
        for (int studentNum : A) {
            studentNum -= B;
            count++;
            if (studentNum > 0) {
                if (studentNum % C == 0) {
                    count += studentNum / C;
                } else {
                    count += studentNum / C + 1;
                }
            }
        }
        System.out.println(count);
    }
}
