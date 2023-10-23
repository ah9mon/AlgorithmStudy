import java.util.*;

public class ProgrammersHash4 {
    private static int N;
    private static int rlt;
    private static int[] visited;
    private static Map<String, Integer> map = new HashMap();

    public int solution(String[][] clothes) {
        // map 정리
        for (int idx = 0; idx < clothes.length; idx++) {
            if (map.containsKey(clothes[idx][1])) {
                map.put(clothes[idx][1], map.get(clothes[idx][1]) + 1);
            } else {
                map.put(clothes[idx][1], 2); // 입음, 안입음
            }
        }
        int sum = 1;
        for (String key : map.keySet()) {
            sum *= map.get(key);
        }

        return sum - 1;

    }
}