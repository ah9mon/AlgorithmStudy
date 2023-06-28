/*
* 카드 뭉치
* https://school.programmers.co.kr/learn/courses/30/lessons/159994
* */

public class Week2_3 {
    public static void main(String[] args) {
    }
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            int p=0; // card1
            int q=0; // card2
            int r=0; // goal

            int pLen = cards1.length;
            int qLen = cards2.length;
            int rLen = goal.length;

            while(r<rLen){
                if(p < pLen && goal[r].equals(cards1[p])){ // 목표카드가 card1과 같은지
                    p++;
                } else if(q < qLen && goal[r].equals(cards2[q])) { // 목표카드가 card2와 같은지
                    q++;
                }else{
                    return "NO";
                }
                r++;
            }
            return "YES";
        }
    }
}

/*
* equals() => 객체의 내용을 비교하여 동등성 판단
* */
