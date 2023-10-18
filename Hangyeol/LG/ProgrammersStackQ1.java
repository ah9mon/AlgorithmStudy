import java.util.*;

public class ProgrammersStackQ1 {
    public Deque<Integer> solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque();

        for (int n : arr) {
            if (deque.isEmpty() || deque.peekLast() != n) {
                deque.add(n);
            }
        }

        return deque;
    }
}
