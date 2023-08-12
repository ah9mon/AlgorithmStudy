import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Average {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
        }

        int maxGrade = Arrays.stream(grades).max().getAsInt();

        double avg = Arrays.stream(grades)
                .mapToDouble(grade -> (float) grade/maxGrade*100)
                .average()
                .orElse(0);

        System.out.println(avg);
    }
}