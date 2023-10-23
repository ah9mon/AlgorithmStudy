import java.util.*;

public class ProgrammersStackQ6 {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque();
        int[] rlt = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                int preIndex = stack.pollLast();
                rlt[preIndex] = i - preIndex;
            }
            stack.add(i);
        }

        int lastIndex = stack.peekLast();

        for (int i : stack) {
            rlt[i] = lastIndex - i;
        }

        return rlt;
    }
}
