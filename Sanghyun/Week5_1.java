import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

import static java.util.Arrays.*;

/*
과일 장수
* https://school.programmers.co.kr/learn/courses/30/lessons/135808
* */
public class Week5_1 {
    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i< score.length;i++)
                rpq.add(score[i]);

            while (rpq.size() >= m){
                for(int i=0;i<m;i++){
                    if(i== m-1){
                        answer = answer + (rpq.poll()*m);
                    }
                    else{
                        rpq.poll();
                    }
                }
            }
            return answer;
        }
    }
}

