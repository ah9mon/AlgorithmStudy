import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AgeSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        Queue<String>[] deques = new LinkedList[201];
//        for (int index = 0; index < 201; index++) {
//            deques[index] = new LinkedList<>();
//        }

        Queue<String>[] deques = new ArrayDeque[201];
        for (int index = 0; index < 201; index++) {
            deques[index] = new ArrayDeque<>();
        }

//        long startTime = System.nanoTime(); // 시작 시간 측정

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            deques[age].add(name);
        }

        StringBuilder sb = new StringBuilder();
        for (int index = 1; index < 201; index++) {
            Queue<String> deque = deques[index];
            while (!deque.isEmpty()) {
                sb.append(index + " ").append(deque.poll()).append("\n");
            }
        }

//        long endTime = System.nanoTime(); // 종료 시간 측정
//        long duration = endTime - startTime; // 실행 시간 계산 (나노초 단위)

//        System.out.println("Execution Time: " + duration / 1000000 + " milliseconds"); // 밀리초 단위로 출력

        System.out.println(sb);
    }
}
