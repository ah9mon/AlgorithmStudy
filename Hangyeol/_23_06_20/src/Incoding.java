import java.util.*;
public class Incoding {
    public StringBuilder solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);

            char changedAlphabet = changeAlphabet(alphabet, skip ,index);
            answer.append(changedAlphabet);
        }
        return answer;
    }

    private static char changeAlphabet(char alphabet, String skip, int index) {
        for (int i = 1; i <= index; i++) {
            alphabet = addAndCheckRange(alphabet);

            // skip검사
            while (skip.contains(String.valueOf(alphabet))) {
                alphabet = addAndCheckRange(alphabet);
            }
        }
        return alphabet;
    }

    private static char addAndCheckRange(char alphabet) {
        alphabet = (alphabet == 'z') ? 'a' : (char) (alphabet + 1);
        return alphabet;
    }
}
