import java.util.*;

public class ProgrammersPriorityQueue2 {
    public int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] j1, int[] j2) {
                return j1[0] - j2[0];
            }
        });

        int N = jobs.length;
        int time = 0;
        int sum = 0; // 요청부터 종료 시간의 합

        // 정렬기준은 처리 시간, 오름차순
        PriorityQueue<int[]> heap = new PriorityQueue(new Comparator<int[]>(){
            public int compare(int[] j1, int[]j2) {
                return j1[1] - j2[1];
            }
        });

        int idx = 0;
        int count = 0;
        while(count < N) {
            // 요청 받아서 대기 큐에 넣기
            while (idx < N && jobs[idx][0] <= time) {
                heap.add(jobs[idx]);
                idx++;
            }

            // 대기 큐에 있는거 실행
            if (!heap.isEmpty()) {
                int[] job = heap.poll();
                time += job[1];
                sum += (time - job[0]);
                count++;
            } else {
                time = jobs[idx][0];
            }
        }

        return sum / N;
    }
}
