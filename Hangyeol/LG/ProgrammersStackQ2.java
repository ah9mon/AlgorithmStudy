import java.util.*;

public class ProgrammersStackQ2 {
    Deque<Character> deque = new ArrayDeque();
    boolean solution(String s) {
        for (char charValue : s.toCharArray()) {
            if (!deque.isEmpty()
                    && (deque.peekFirst() == '(' && charValue == ')'))  {
                deque.pollFirst();
                continue;
            }
            deque.add(charValue);
        }

        if (deque.isEmpty()) return true;
        return false;
    }
}
