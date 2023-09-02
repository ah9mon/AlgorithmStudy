import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* [#1] 좌표 정렬하기 study
https://www.acmicpc.net/problem/11650
* */
public class No11650 {
    static class Node implements Comparable<Node> {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node other) {
            if (this.x == other.x) return this.y - other.y;
            else return this.x - other.x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        Collections.sort(list);
        for (Node x : list) {
            System.out.println(x.x + " " + x.y);
        }
    }
}

