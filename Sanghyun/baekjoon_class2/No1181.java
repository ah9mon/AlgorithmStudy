import java.util.*;

/* [#1] 단어정렬 study
https://www.acmicpc.net/problem/1181
* */
public class No1181 {

    static class Words implements Comparable<Words> {
        int len;
        String str;

        Words(String str, int len) {
            this.str = str;
            this.len = len;
        }

        @Override
        public int compareTo(Words o) {
            if (this.len != o.len) return this.len - o.len;
            else return this.str.compareTo(o.str);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            set.add(s); // 중복제거
        }

        ArrayList<Words> list = new ArrayList<>();
        for (String word : set) {
            list.add(new Words(word, word.length()));
        }
        Collections.sort(list);

        for (Words word : list) {
            System.out.println(word.str);
        }
    }
}

