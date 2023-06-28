import java.util.*;
class Solution {
    public LinkedList solution(String today, String[] terms, String[] privacies) {
        LinkedList<Integer> answer = new LinkedList<>();
        int[] todayArray = makeIntArray(today); // 오늘 날짜 Array

        for (int i = 0; i < terms.length; i++) {

            // terms[i]
            String[] expirationPeriodInfo = terms[i].split(" ");
            String termsName = expirationPeriodInfo[0]; // terms 이름
            int expirationPeriod = Integer.parseInt(expirationPeriodInfo[1]); // terms 유효기간

            for (int j = 0; j < privacies.length; j++) {

                String[] privaciesInfo = privacies[j].split(" "); // 개인정보
                int[] day = makeIntArray(privaciesInfo[0]); // 개인정보 최초 등록된 날

                if (privaciesInfo[1].equals(termsName)){ // 개인정보 이름과 terms이름 같으면
                    addPeriod(expirationPeriod, day); // 개인정보 최초 등록 기간 + 유효기간

                    for (int k = 0; k < 3; k++) { // 년 월 일 비교

                        if (day[k] < todayArray[k]) { // 오늘 보다 작으면 만료
                            answer.add(j+1); // 인덱스 추가
                            break;

                        } else if (day[k] > todayArray[k]) { // 오늘 보다 크면 만료안된거
                            break;
                        }
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    private static int[] makeIntArray(String today) {
        int[] todayArray = Arrays.stream(today.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
        return todayArray;
    }

    private static void addPeriod(int expirationPeriod, int[] day) {
        int year = expirationPeriod/12;
        int month = expirationPeriod%12;
        day[0] += year;
        day[1] += month;

        if (day[1] > 12) {
            day[1] -= 12;
            day[0] ++;
        }

        day[2] --;
        if (day[2] == 0) {
            day[2] = 28;
            day[1]--;
            if(day[1] == 0) {
                day[1] = 12;
                day[0]--;
            }
        }
    }
}
