import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* [#1] 덱 study
equals -> 객체의 내용을 비교
== -> 객체의 참조를 비교 ( 메모리 내에서 동일한 위치 )
https://www.acmicpc.net/problem/10866
* */
public class No10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);

        int cnt = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push_front")) {
                int e = Integer.parseInt(st.nextToken());
                dq.addFirst(e);
            } else if (cmd.equals("push_back")) {
                int e = Integer.parseInt(st.nextToken());
                dq.addLast(e);
            } else if (cmd.equals("pop_front")) {
                if (dq.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(dq.pollFirst());
            } else if (cmd.equals("pop_back")) {
                if (dq.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(dq.pollLast());
            } else if (cmd.equals("size")) {
                System.out.println(dq.size());
            } else if (cmd.equals("empty")) {
                if (dq.isEmpty()) System.out.println("1");
                else System.out.println("0");
            } else if (cmd.equals("front")) {
                if (dq.isEmpty()) System.out.println("-1");
                else System.out.println(dq.peekFirst());
            } else if (cmd.equals("back")) {
                if (dq.isEmpty()) System.out.println("-1");
                else System.out.println(dq.peekLast());
            }
        }
    }
}

