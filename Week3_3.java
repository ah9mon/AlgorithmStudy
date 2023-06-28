/*
가장 가까운 글자
* https://school.programmers.co.kr/learn/courses/30/lessons/142086
* */
public class Week3_3 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            answer[0] = -1; // 첫문자 -1

            for(int i=1;i<s.length();i++){
                for(int j=i-1;j>=0;j--){
                    if(s.charAt(i) != s.charAt(j)){ // 다르면 -1
                        answer[i] = -1;
                        continue;
                    }
                    if(s.charAt(i) == s.charAt(j)) {
                        answer[i] = i-j; // 현재위치에서 해당 인덱스 빼기
                        break;
                    }
                }
            }
            return answer;
        }
    }
}


