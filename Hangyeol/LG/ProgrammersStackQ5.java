import java.util.*;

public class ProgrammersStackQ5 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque();
        int N = truck_weights.length;

        int[] sec = new int[N];

        // 첫차 출발
        q.add(0);
        int wSum = truck_weights[0];
        int idx = 1;
        int rlt = 0;
        while(!q.isEmpty()) {
            // + 1초
            for (int i : q) {
                sec[i] += 1;
            }
            rlt++;

            // 나갈지 확인
            if (sec[q.peekFirst()] >= bridge_length) {
                int index = q.pollFirst();
                wSum -= truck_weights[index];
            }

            // 다음차 들어올지 확인
            if (idx < N && wSum + truck_weights[idx] <= weight) {
                wSum += truck_weights[idx];
                q.add(idx);
                idx++;
            }
        }
        return rlt + 1;
    }
}
