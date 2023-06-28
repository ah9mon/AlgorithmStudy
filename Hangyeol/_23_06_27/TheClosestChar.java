public class TheClosestChar {
    public int[] solution(String s) {
        int LEN_S = s.length();
        String[] sToArray = s.split("");
        int[] answer = new int[LEN_S];

        for (int index = 0; index < LEN_S; index++) {
            String target = sToArray[index];
            // sToArray[index - 1] 부터 왼쪽 방향으로 탐색
            for (int sameStringIndex = index - 1; sameStringIndex >= 0; sameStringIndex--) {
                if (target.equals(sToArray[sameStringIndex])) {
                    answer[index] = index - sameStringIndex;
                    break;
                }
            }
            if (answer[index] == 0) answer[index] = -1;
        }
        return answer;
    }
}
