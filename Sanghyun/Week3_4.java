/*
문자열 압축
* https://school.programmers.co.kr/learn/courses/30/lessons/60057
하나가 계속 틀림 -> 길이가 1인경우
* */
public class Week3_4 {
    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            int len = s.length();

            /* 입력 받는 문자열의 길이가 1일때 */
            if(s.length() == 1)
                return 1;

            for(int i=1;i<=len/2;i++){ // 1부터 압축단위 늘려감
                String target = s.substring(0,i); // 문자열 압축 target
                int cnt = 1; // target
                StringBuilder sb = new StringBuilder();

                for(int j=i; j<=s.length()-i; j +=i){
                    if(target.equals(s.substring(j,j+i))){ // 다음에 오는 문자열과 같다면
                        cnt++;
                    }
                    else{
                        // abcabc => 2abc
                        if(cnt > 1){
                            sb.append(cnt);
                        }
                        sb.append(target);

                        // 다른 문자열이 왔으니까 타겟 변경
                        target = s.substring(j,j+i);
                        cnt = 1;
                    }
                }
                // 마지막에 압축 시키지 않은 문자열
                if(cnt>1) sb.append(cnt);
                sb.append(target);

                int remain = s.length() % i ; // i개로 자르고 남은 길이
                answer = Math.min(answer,sb.length()+remain);
            }
            return answer;
        }
    }
}


