import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#1] 직각삼각형 study
대각선변을 생각 안해줬음 -> 그냥 크기순으로 입력되는줄
https://www.acmicpc.net/problem/4153
* */
public class No4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (a != 0 && b != 0 && c != 0) {
            if ((a * a + b * b) == c * c) {
                System.out.println("right");
            } else if ((a * a + c * c) == b * b) {
                System.out.println("right");
            } else if ((b * b + c * c) == a * a) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }


            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}

