/*
문자열 나누기
https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */

public class SplitString {
    public int solution(String s) {
        String[] sArray = s.split(""); // s.toCharArray() 란 것도 있다. 이게 더 나을듯
        int LEN_S = sArray.length;

        String first =  sArray[0]; // x
        int countSame = 1; // x랑 같은거 카운트
        int countDiff = 0; // x랑 다른거 카운트
        int countDivide = 1; // 분리된 문자열 개수

        for (int index = 1; index < LEN_S; index++) {

            // x와 같은지 검사
            if (first.equals(sArray[index])) {
                countSame++;
            } else {
                countDiff++;
            }

            // 횟수 검사
            if (countDiff == countSame) {
                if (index == LEN_S - 1) break; // 문자열 끝났으면 종료

                // 새로운 문자열 시작
                countDivide++;
                index++;
                first = sArray[index];
                countSame = 1;
                countDiff = 0;
            }
        }
        return countDivide;
    }
}
