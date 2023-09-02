import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* [#1] 나이순 정렬 study
나이가 같으면 이름으로 정렬하는 줄 알았음 -> 그냥 입력순임
https://www.acmicpc.net/problem/10814
* */
public class No10814 {
    static class Person implements Comparable<Person> {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person other) {
            if (this.age == other.age) return 0;
            else return this.age - other.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            Person p = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
            list.add(p);
        }

        Collections.sort(list);
        for (Person x : list) {
            System.out.println(x.age + " " + x.name);
        }
    }
}

