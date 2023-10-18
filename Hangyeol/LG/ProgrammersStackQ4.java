import java.util.*;

public class ProgrammersStackQ4 {
    public int solution(int[] priorities, int location) {

        Deque<Integer> q = new ArrayDeque();
        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int firstProcess = q.pollFirst();
            boolean flag = true;
            for(int process : q) {
                if (priorities[firstProcess] < priorities[process]) {
                    flag = false;
                }
            }

            if (flag) {
                count++;
                if (location == firstProcess) break;
            } else if (!flag) {
                q.add(firstProcess);
            }
        }

        return count;
    }
}
