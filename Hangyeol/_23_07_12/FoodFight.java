public class FoodFight {
    public StringBuilder solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        // 한 선수가 먹을 음식 순서 생성
        for (int foodNumber = 1; foodNumber < food.length; foodNumber++) {
            int numberOfFood = food[foodNumber] / 2;
            for (int count = 0; count < numberOfFood; count++) {
                answer.append(foodNumber);
            }
        }

        // 다른 선수가 먹을 음식도 세팅
        StringBuilder reverseAnswer = new StringBuilder(answer);
        reverseAnswer.reverse();
        answer.append("0"); // 가운데 물놓기
        answer.append(reverseAnswer);
        return answer;
    }
}
