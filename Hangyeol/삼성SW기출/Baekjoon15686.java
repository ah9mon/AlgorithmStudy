import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15686 {

    private static int N;
    private static int M;
    private static CityInfo cityInfo;
    private static int minChickenDistance = 10000;

    static class CityInfo{
        int[] savedChickenStore;
        List<int[]> homeLocation = new LinkedList<>();
        int numberOfHome;
        List<int[]> chickenStoreLocation = new LinkedList<>();
        int numberOfChickenStore;

        public CityInfo() {
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        cityInfo = new CityInfo();

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String now = st2.nextToken();
                if (now.equals("2")) {
                    cityInfo.chickenStoreLocation.add(new int[]{j,i});
                } else if (now.equals("1")) {
                    cityInfo.homeLocation.add(new int[]{j, i});
                }
            }
        }
        cityInfo.numberOfChickenStore = cityInfo.chickenStoreLocation.size();
        cityInfo.numberOfHome = cityInfo.homeLocation.size();
        cityInfo.savedChickenStore = new int[cityInfo.numberOfChickenStore];

        findMinChickenDistance(0, 0);
        System.out.println(minChickenDistance);
    }

    private static void findMinChickenDistance(int storeCount, int index) {
        if (storeCount == M) {
            int sumOfChickenDistance = 0;
            // 치킨집 다 골랐으면 거리 세기
            for (int[] home : cityInfo.homeLocation) {
                sumOfChickenDistance += addChickenDistance(new int[]{home[0], home[1]});
            }

            // 현재 최솟값과 비교
            if (minChickenDistance > sumOfChickenDistance) minChickenDistance = sumOfChickenDistance;

        } else if (index == cityInfo.numberOfChickenStore) {
            return;
        } else {
            // 치킨집 다 안골랐으면 치킨집 고르기
            if (cityInfo.savedChickenStore[index] == 0) {
                // 치킨집 살리기
                cityInfo.savedChickenStore[index] = 1;
                findMinChickenDistance(storeCount + 1, index + 1);

                // 취소
                cityInfo.savedChickenStore[index] = 0;
                findMinChickenDistance(storeCount, index + 1);
            }
        }
    }

    private static int addChickenDistance(int[] home) {
        int chickenDistance = 10000;
        for (int index = 0; index < cityInfo.numberOfChickenStore; index++) {
            if (cityInfo.savedChickenStore[index] == 1) {
                int[] store = cityInfo.chickenStoreLocation.get(index);
                int distance = Math.abs(home[0] - store[0]) + Math.abs(home[1] - store[1]);
                if (chickenDistance > distance) chickenDistance = distance;
            }
        }
        return chickenDistance;
    }
}
