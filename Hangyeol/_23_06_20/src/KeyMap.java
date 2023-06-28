public class KeyMap {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int targetsIndex = 0; targetsIndex < targets.length; targetsIndex++) {
            boolean flag = true;
            int count = 0;
            String target = targets[targetsIndex];
            for (int index = 0; index < target.length(); index++) {
                char charValue = target.charAt(index);
                int keyDown = checkMinKeyDown(charValue, keymap);

                if (keyDown == 102) {
                    flag = false;
                    break;
                }
                count += keyDown;
            }
            if (!flag) count = -1;
            answer[targetsIndex] = count;
        }
        return answer;
    }

    private static int checkMinKeyDown(char charValue, String[] keymap) {
        int count = 102;
        for (String key:keymap) {
            for (int keyCount = 0; keyCount < key.length(); keyCount++) {
                if (key.charAt(keyCount) == charValue) {
                    if (count > keyCount + 1) count = keyCount + 1;
                }
            }
        }
        return count;
    }
}
