import java.util.Arrays;
import java.util.PriorityQueue;

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int index = score.length - 1;
        Arrays.sort(score); // 오름 차순 정렬

        while (true) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 사과 상자
            int count = 0; // minHeap에 들어간 사과 개수
            while (count < m && index >= 0) {
                minHeap.add(score[index]);
                index--;
                count++;
            }

            if (count == m) {
                answer += (minHeap.peek() * m);
            } else {
                break;
            }
        }

        return answer;
    }
}
