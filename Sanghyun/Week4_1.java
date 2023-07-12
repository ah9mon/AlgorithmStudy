import java.util.*;
import java.lang.*;
/*
문자열 나누기
* https://school.programmers.co.kr/learn/courses/30/lessons/140108
* */
public class Week4_1 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            int cnt_same = 0;
            int cnt_diff = 0;
            int i=0;
            for(char x : s.toCharArray() ){
                if(x == s.charAt(i)){ // 같은 문자가 나온경우
                    cnt_same++;
                }
                else{ // 다른 문자가 나온경우
                    cnt_diff++;
                }

                if(cnt_same == cnt_diff){ // 문자열 분리
                    answer++;
                    i = i + cnt_same + cnt_diff; // index 이동
                    cnt_same = cnt_diff = 0;
                }
            }
            if(i != s.length()){ // 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면
                answer++;
            }
            return answer;
        }
    }
}

/*
* for each문
* 배열이나 컨테이너 형식으로 사용해야함
* String을 쓰기 위해서는 .toCharArray()를 통해 문자열을 문자배열로 변경
* */
