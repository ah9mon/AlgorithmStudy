import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberCards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[20000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            cards[10000000 + Integer.parseInt(st.nextToken())]++;
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            sb.append(cards[10000000 + Integer.parseInt(st2.nextToken())] + " ");
        }

        System.out.println(sb);
    }
}
