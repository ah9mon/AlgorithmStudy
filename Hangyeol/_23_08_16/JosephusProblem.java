import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JosephusProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int pointer = 1;
        int count = 0;
        int check = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (count < n) {
            if (isNotChecked(arr, pointer)) { // 체크 안한 숫자면
                // k번째 숫자인지 확인
                if (check == k) { // k번째 숫자면
                    count++;
                    arr[pointer] = 1;
                    check = 1;
                    addToStringBuilder(pointer, count, n, sb);
                } else {
                    check++;
                }
            }

            pointer = pointNext(pointer, n); // 다음 확인
        }

        System.out.println(sb);
    }

    private static void addToStringBuilder(int pointer, int count, int n, StringBuilder sb) {
        if (count == n) {
            sb.append(pointer + ">");
        } else {
            sb.append(pointer + ", ");
        }
    }

    private static boolean isNotChecked(int[] arr, int pointer) {
        if (arr[pointer] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static int pointNext(int pointer, int n) {
        int nextPoint = pointer + 1;
        if (nextPoint > n) {
            nextPoint = 1;
        }
        return nextPoint;
    }
}
