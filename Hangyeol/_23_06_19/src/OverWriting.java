public class OverWriting {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        for (int i = 0; i < section.length; i++) {
            int now = section[i] + m - 1;
            for (int j = i; j < section.length; j++) {
                if (section[j] > now) {
                    i = j - 1;
                    count ++;
                    break;
                }
            }
        }
        return count + 1;
    }
}
