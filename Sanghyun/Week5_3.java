import java.util.Stack;

/*
햄버거 만들기
* https://school.programmers.co.kr/learn/courses/30/lessons/133502
* */
public class Week5_3 {
    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            Stack<Integer> s = new Stack<>();

            for (int x : ingredient) {
                s.push(x);

                if (s.size() >= 4) {
                    if (s.get(s.size() - 1) == 1 &&
                            s.get(s.size() - 2) == 3 &&
                            s.get(s.size() - 3) == 2 &&
                            s.get(s.size() - 4) == 1) {
                        answer++;
                        for (int i = 0; i < 4; i++)
                            s.pop();
                    }
                }
            }
            return answer;
        }
    }
}
// 1 2 3 1

/*
* stack.get(int) -> index로 값 가져옴
* */

