/*
덧칠하기 문제
* https://school.programmers.co.kr/learn/courses/30/lessons/161989
* */
public class Week2_1 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int cnt=0;

            int L = section.length;
            int paintNow = section[0];
            int idx = 0;

            while( idx < L ) { // section의 길이만큼 반복
                if (paintNow <= section[idx]) { // 현재칠한 구역 <= 칠해야할 구역
                    paintNow = section[idx] + m;
                    cnt++;
                }
                idx++;
            }
            return cnt;
        }
    }
}

