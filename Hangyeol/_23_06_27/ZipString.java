class ZipString {
    public int solution(String s) {
        int LEN_S = s.length();

        int minLength = 1000;
        for (int i = LEN_S/2 != 0 ? LEN_S/2 : 1 ; i > 0; i--) {
            int nowMinLength = getLength(i, s, LEN_S);
            if (nowMinLength < minLength) minLength = nowMinLength;
        }

        return minLength;
    }

    private static int getLength(int i, String s, int LEN_S) {
        // 문자열을 i개 단위로 잘라 압축했을 때의 최소 길이 찾기
        StringBuilder sb = new StringBuilder();
        for (int startIndex = 0; startIndex <= LEN_S; startIndex += i) {

            if (startIndex > LEN_S - i) {
                sb.append(s.substring(startIndex, LEN_S));
                break;
            }

            String cuttedString = s.substring(startIndex, startIndex + i); // s[startIndex ~ startIndex + i]

            int count = 1; // 연속된 수 카운트

            for (int startIndex2 = startIndex + i; startIndex2 <= LEN_S - i; startIndex2 += i) {

                String cuttedString2 = s.substring(startIndex2, startIndex2 + i); // s[startIndex + i ~ startIndex + 2i];

                if (cuttedString.equals(cuttedString2)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count > 1) {
                sb.append(count + cuttedString);
            } else {
                sb.append(cuttedString);
            }
            startIndex += (count - 1) * i; // 카운트 된 곳까지 startIndex 옮기기
        }
        return sb.length();
    }
}
