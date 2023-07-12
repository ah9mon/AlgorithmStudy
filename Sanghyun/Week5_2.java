import java.util.Collections;
import java.util.PriorityQueue;

/*
푸드 파이트 대회
* https://school.programmers.co.kr/learn/courses/30/lessons/134240
* */
public class Week5_2 {
    class Solution {
        public String solution(int[] food) {
            String answer = "";

            for(int i=0; i<food.length;i++){
                for(int j=0;j<food[i]/2;j++){
                    answer += i;
                }
            }
            StringBuilder sb = new StringBuilder(answer).reverse();
            answer += 0 + sb.toString();

            return answer;
        }
    }
}

