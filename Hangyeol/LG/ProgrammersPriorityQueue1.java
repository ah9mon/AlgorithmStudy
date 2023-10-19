import java.util.*;

public class ProgrammersPriorityQueue1 {
    public int solution(int[] scoville, int K) {
        // 낮은게 우선인 우선순위 큐 초기화
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int s : scoville) {
            pq.add(s);
        }

        int count = 0; // 섞는 횟수
        // 하나 꺼냄
        int food = pq.peek();
        while(food < K) {

            if (pq.size() < 2) return -1;

            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(createNewFood(s1,s2));
            count++;
            food = pq.peek();
        }
        return count;
    }

    private static int createNewFood(int s1, int s2) {
        return s1 + (s2 * 2);
    }
}
