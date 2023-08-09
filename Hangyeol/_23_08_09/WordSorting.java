
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;

public class WordSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aNumberOfWords = Integer.parseInt(br.readLine());
        LinkedList<String>[] lst = new LinkedList[51];

        for (int i = 0; i < 51; i++) {
            lst[i] = new LinkedList<>(); // 각 요소를 LinkedList로 초기화
        }

        for (int j = 0; j < aNumberOfWords; j++) {
            String word = br.readLine();
            lst[word.length()].add(word);
        }

        for (int len = 1; len < 51; len++) {
            if (!lst[len].isEmpty()) {
                String previousWord = "";
                lst[len].sort(Comparator.naturalOrder());
                for (int index = 0; index < lst[len].size(); index++) {
                    String nowWord = lst[len].get(index);
                    if (!nowWord.equals(previousWord)) {
                        System.out.println(nowWord);
                        previousWord = nowWord;
                    }
                }
            }
        }
    }
}
