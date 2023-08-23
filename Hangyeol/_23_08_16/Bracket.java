import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            Queue<Character> queue = new LinkedList<>();
            String str = br.readLine();
            for (int index = 0; index < str.length(); index++) {
                char charValue = str.charAt(index);

                if (queue.isEmpty()) {
                    queue.add(charValue);
                } else {
                    if (charValue == '(') {
                        queue.add(charValue);
                    } else {
                        if (queue.peek() == '(') {
                            queue.poll();
                        } else {
                            break;
                        }
                    }

                }
            }
            if (queue.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
