import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon14888 {

    private static int[] count = new int[4];
    private static int[] numbers;
    private static int N;

    private static Deque<Integer> result = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(numbers[0], 1);
        System.out.println(result.peekLast());
        System.out.println(result.peekFirst());
    }

    private static void dfs(int answer, int index) {
        if (index == N) {
            if (result.isEmpty()) {
                result.add(answer);
            } else {
                int min = result.peekFirst();
                int max = result.peekLast();
                if (min > answer) result.addFirst(answer);
                if (max < answer) result.addLast(answer);
            }
        } else {
            if (count[0] > 0) {
                count[0] --;
                dfs(answer + numbers[index], index + 1);
                count[0] ++;
            }

            if (count[1] > 0) {
                count[1] --;
                dfs(answer - numbers[index], index + 1);
                count[1] ++;
            }

            if (count[2] > 0) {
                count[2]--;
                dfs(answer * numbers[index], index + 1);
                count[2]++;
            }

            if (count[3] > 0) {
                count[3]--;
                dfs(answer / numbers[index], index + 1);
                count[3]++;
            }
        }
    }
}
