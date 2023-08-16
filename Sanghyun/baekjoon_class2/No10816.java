import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#1] 숫자 카드 2 study
1 -> 시간초과 리스트에 담아서 System.out 으로 출력 -> StringBuilder로 해결
https://www.acmicpc.net/problem/10816
* */
public class No10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(target, 0) + " ");
        }

        System.out.println(sb);

    }
}

