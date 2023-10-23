import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon20055 {

    private static int N;
    private static int K;
    private static int count;
    private static int[] conditions;
    private static int[] robotLocations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());
        conditions = new int[2 * N + 1];
        robotLocations = new int[2 * N + 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            conditions[i] = Integer.parseInt(st2.nextToken());
        }

        int stage = 1;
        while (true) {
            turn(); // 1

            moveRobot(); // 2

            putRobotOnBelt(); // 3

            // 4
            if (isOver()) {
                System.out.println(stage);
                break;
            }
            stage++;
        }

    }

    private static void turn() {
        // 벨트 한칸 씩 이동
        int beltTemp = conditions[2 * N];
        for (int index = 2 * N; index > 0; index--) {
            conditions[index] = conditions[index - 1];
        }
        conditions[1] = beltTemp;

        // 로봇 한칸 씩 이동
        for (int index = N; index > 0; index--) {
            robotLocations[index] = robotLocations[index - 1];
        }
    }

    private static void moveRobot() {
        for (int index = N; index > 0; index--) {
            if (index == N) {
                robotLocations[index] = 0; // 로봇 하차
            } else {
                if (robotLocations[index] == 1 && robotLocations[index + 1] == 0 && conditions[index + 1] > 0) {
                    robotLocations[index] = 0;
                    robotLocations[index + 1] = 1; // 이동
                    conditions[index + 1] -= 1;
                    countZeroCondition(conditions[index + 1]);
                }
            }
        }
    }

    private static void putRobotOnBelt() {
        if (conditions[1] > 0) {
            robotLocations[1] = 1;
            conditions[1] -= 1;
            countZeroCondition(conditions[1]);
        }
    }

    private static boolean isOver() {
        if (count >= K) return true;
        return false;
    }

    private static void countZeroCondition(int condition) {
        if (condition == 0) count++;
    }
}
