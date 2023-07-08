import java.util.ArrayList;
import java.util.Arrays;

public class Cards {
    // 다시 같은 카드 사용 불가
    // i 번째 사용하지 않고 i + n번째 카드 사용 불가

    public String solution (String[] cards1, String[] cards2, String[] goal) {
        int cards1Index = 0;
        int cards2Index = 0;

        for (int goalIndex = 0; goalIndex < goal.length; goalIndex++) {
            boolean cards1Bool = checkWord(cards1, cards1Index, goal, goalIndex);
            boolean cards2Bool = checkWord(cards2,cards2Index, goal, goalIndex);

            if (cards1Bool) cards1Index++;

            if (cards2Bool) cards2Index++;

            if (!(cards1Bool || cards2Bool)) {
                return "No";
            }
        }

        return "Yes";
    }

    private static boolean checkWord(String[] cards, int cardIndex, String[] goal, int goalIndex) {
        boolean flag = false;
        if (cardIndex < cards.length && cards[cardIndex].equals(goal[goalIndex])) flag = true;
        return  flag;
    }
}
