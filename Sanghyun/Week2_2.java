/*
* 대충 만든 자판
* https://school.programmers.co.kr/learn/courses/30/lessons/160586
* */

/*
 * 1. 타겟이 있는지 없는지 판단
 * 2. 키맵들중 타겟이 있다면, 어느것이 최소인덱스인지 판단
 * 3. 인덱스 더하기
 */
public class Week2_2 {
    public static void main(String[] args) {
    }
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int [] answer = new int [targets.length];
            for(int i=0;i<targets.length;i++){ // targets
                int result = 0;
                String target = targets[i];

                for(int j=0;j <target.length();j++){
                    int minIdx = 101;
                    for(String k : keymap){
                        int idx = k.indexOf(target.charAt(j));
                        if(idx == -1) continue;
                        minIdx = Math.min(minIdx,idx+1);
                    }
                    if(minIdx == 101){
                        result = -1;
                        break;
                    }
                    result += minIdx;
                }

                answer[i] = result;
            }
            return answer;
        }
    }
}

/*
* indexOf() => 문자열객체에서 특정 문자나 문자열이 처음으로 등장하는 인덱스 반환
*           => 존재하지 않는 경우에는 -1 , 존재하는 경우에는 해당 인덱스
* */
