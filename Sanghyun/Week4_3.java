/*
기사단원의 무기
* https://school.programmers.co.kr/learn/courses/30/lessons/136798
* */
public class Week4_3 {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            for(int i=1;i <=number;i++){
                int cnt = 0;
                int sqrt = (int)Math.sqrt(i);

                for(int j=1; j<=sqrt;j++){
                    if( i%j == 0){
                        if(j*j == i) cnt+=1;
                        else cnt+=2;
                    }
                }
                cnt = cnt > limit ? power : cnt;
                answer += cnt;
            }
            return answer;
        }
    }
}

/*
* 약수를 제곱근으로 계산 -> 시간복잡도 O(n^루트n)
* */