import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < 2000001; index++) {
            if (arr[index]) sb.append(index - 1000000).append("\n");
        }

        System.out.println(sb);
    }
}
