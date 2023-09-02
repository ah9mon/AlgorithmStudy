import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#1] 블랙잭 study
투포인터 슬라이딩 윈도우 생각함 -> x ( 연속된 수로 구하는게 아님 )
https://www.acmicpc.net/problem/2798
* */
public class No2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int card[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum = card[i] + card[j] + card[k];
                    if (sum <= m )
                        ans = Math.max(ans,sum);
                }
            }
        }
        System.out.println(ans);
    }
}

