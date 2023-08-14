import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            commandStack(br.readLine(), sb, deque);
        }
        System.out.println(sb);
    }

    private static void commandStack(String commandLine, StringBuilder sb, Deque<String> deque) {
        StringTokenizer st = new StringTokenizer(commandLine);
        String command = st.nextToken();
        if (command.equals("push")) {
            deque.addLast(st.nextToken());
        } else if (command.equals("pop")) {
            String num = deque.pollLast();
            if (num == null) {
                sb.append("-1").append("\n");
            } else {
                sb.append(num).append("\n");
            }
        } else if (command.equals("size")) {
            sb.append(deque.size()).append("\n");
        } else if (command.equals("empty")) {
            if (deque.isEmpty()) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        } else if (command.equals("top")) {
            String num = deque.peekLast();
            if (num == null) {
                sb.append("-1").append("\n");
            } else {
                sb.append(num).append("\n");
            }
        }
    }
}
