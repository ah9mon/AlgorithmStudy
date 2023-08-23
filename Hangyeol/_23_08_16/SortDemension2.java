import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortDemension2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (map.get(key) != null) {
                map.get(key).add(value);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(value);
                map.put(key, list);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key = -100000; key < 100001; key ++) {
            if(map.get(key) != null) {
                List<Integer> valueList = map.get(key);
                Collections.sort(valueList);
                for (Integer value : valueList) {
                    sb.append(key + " " + value).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
