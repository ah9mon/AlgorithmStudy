import java.util.*;

/* [#1] 수 찾기 study
1 - > set자료구조 이용
2 - > 이진탐색 이용해보기
https://www.acmicpc.net/problem/1920
* */
public class No1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int elem = sc.nextInt();
            set.add(elem);
        }

        int m = sc.nextInt();
        int arr[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if (set.contains(arr[i])) System.out.println(1);
            else System.out.println(0);
        }
    }
}

