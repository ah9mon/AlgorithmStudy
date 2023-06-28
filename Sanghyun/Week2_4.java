/*
둘만의 암호
* https://school.programmers.co.kr/learn/courses/30/lessons/155652
* */
public class Week2_4 {
    public static void main(String[] args) {
        class Solution {
            public StringBuilder solution(String s, String skip, int index) {
                StringBuilder sb = new StringBuilder();

                for(int i=0;i<s.length();i++){
                    char temp = s.charAt(i);
                    int cnt=0;
                    while(cnt < index){
                        temp++;
                        if(temp >'z') temp -=26;
                        if(skip.contains(temp+""))
                            continue;
                        else
                            cnt++;
                    }
                    sb.append(temp);
                }
                return sb;
            }
        }
    }
}