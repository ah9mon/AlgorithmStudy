import java.util.*;

public class ProgrammersStackQ3 {
    public List<Integer> solution(int[] p, int[] s) {
        int N = p.length;
        Deque<Integer> works = new ArrayDeque();
        for (int i = 0; i < N; i++) {
            works.add(i);
        }

        List<Integer> deployCount = new LinkedList();
        while(!works.isEmpty()) {
            int count = 0;
            for (int idx : works) {
                p[idx] = p[idx] + s[idx];
            }

            for (int idx : works) {
                if (p[idx] >= 100) {
                    works.pollFirst();
                    count++;
                } else {
                    break;
                }
            }

            if (count != 0) {
                deployCount.add(count);
                count = 0;
            }
        }
        return deployCount;
    }
}
