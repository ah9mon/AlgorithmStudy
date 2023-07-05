import java.util.ArrayList;
import java.util.Collections;

/*
명예의 전당(1)
* https://school.programmers.co.kr/learn/courses/30/lessons/138477
* */
public class Week4_2 {
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length]; // 발표
            ArrayList <Integer> rank = new ArrayList<>(); // 명예의전당

            for(int i=0;i<score.length;i++){
                if(i<k){ // k일 이하는 명예의전당
                    rank.add(score[i]);
                    Collections.sort(rank); // 오름차순 정렬
                    answer[i] = rank.get(0);
                    continue;
                }

                int min = rank.get(0);
                if(min < score[i]){
                    rank.remove(0);
                    rank.add(score[i]);
                    Collections.sort(rank);
                }
                answer[i] = rank.get(0);
            }
            return answer;
        }
    }
}
/*
* collections.sort -> O(nlogn)
* */