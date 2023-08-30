import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Beakjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(br.readLine());
        }

        Set<String> set2 = new HashSet<>();
        for (int j = 0; j < m; j++) {
            set2.add(br.readLine());
        }

        set1.retainAll(set2);

        StringBuilder sb = new StringBuilder();
        sb.append(set1.size()).append("\n");
        set1.stream().sorted().forEach(name -> sb.append(name).append("\n"));

        System.out.println(sb);
    }
}
