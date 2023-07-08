/*
프로그래머스 : 크기가 작은 부분문자열

Date : 23/06/27

특이사항 : p의 길이 <= 18 이므로 int가 아닌 long으로
*/



class ComparingSubString {
    public int solution(String t, String p) {
        int answer = 0;
        int LEN_P = p.length();
        long LONG_P = Long.parseLong(p);
        for (int startIndex = 0; startIndex < t.length() - (LEN_P - 1); startIndex++) {
            long subStringNumber = Long.parseLong(t.substring(startIndex, startIndex + LEN_P));

            if (subStringNumber <= LONG_P) answer++;
        }
        return answer;
    }
}

