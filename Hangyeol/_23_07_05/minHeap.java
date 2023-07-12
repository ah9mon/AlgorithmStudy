import java.util.PriorityQueue;

public class minHeap {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int day = 0 ; day < score.length; day++) {
            if (minHeap.size() < k) {
                minHeap.add(score[day]);
            } else if (minHeap.size() == k) {
                if (minHeap.peek() < score[day]) {
                    minHeap.poll();
                    minHeap.add(score[day]);
                }
            }
            answer[day] = minHeap.peek();
        }
        return answer;
    }
}
