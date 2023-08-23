import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Queuequeue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<String> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String commandLine = br.readLine();
            commadQueue(queue, commandLine, sb);
        }

        System.out.println(sb);
    }

    private static void commadQueue(Deque<String> queue, String commandLine, StringBuilder sb) {
        StringTokenizer st = new StringTokenizer(commandLine);
        String command = st.nextToken();
        if (command.equals("push")) {
            queue.addLast(st.nextToken());
        } else if (command.equals("pop")) {
            String num = queue.pollFirst();
            sb.append((num != null) ? num : -1).append("\n");
        } else if (command.equals("size")) {
            sb.append(queue.size()).append("\n");
        } else if (command.equals("empty")) {
            sb.append(queue.isEmpty() ? 1 : 0).append("\n");
        } else if (command.equals("front")) {
            sb.append((queue.peekFirst() != null) ? queue.peekFirst() : -1 ).append("\n");
        } else if (command.equals("back")) {
            sb.append((queue.peekLast() != null) ? queue.peekLast() : -1 ).append("\n");
        }
    }
}
