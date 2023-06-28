/*
크기가 작은 부분문자열
* https://school.programmers.co.kr/learn/courses/30/lessons/161989
* */
public class Week3_2 {
    class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            int pLen = p.length(); // 3
            int loop = t.length()-pLen+1; // 7-3+1
            for(int i=0;i<loop;i++){
                String temp = t.substring(i,i+pLen);
                if(p.compareTo(temp)>=0)
                    answer++;
            }
            return answer;
        }
    }
}

/*
* substring() 호출하는 객체의 부분문자열 추출
* start Idx , end Idx 만큼의 부분 문자열을 반환함
* return 값은 해당 인덱스만큼의 문자열을 반환 string
* */
/*
* compareTo() 두개의 문자열 비교 -> 리스트를 오름차순이나 내림차순으로 정렬도 가능
* return 값은 0 , 음수, 양수의 int값
* 0 : 두개의 문자열이 동일
* 양수 : 호출하는 객체가 인자보다 사전적으로 순서가 앞설때, 즉 먼저 나오는 값
* 음수 : 인자가 객체보다 사전적으로 앞설 때
* */


