public class TheWeaponOfKnight {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int knight = 1; knight <= number; knight++) {
            int numberOfDivisors = getNumberOfDivisors(knight);
            if (numberOfDivisors > limit) {
                answer += power;
            } else {
                answer += numberOfDivisors;
            }
        }
        return answer;
    }

    // 약수의 개수 구하기
    private int getNumberOfDivisors(int target) {

        int numberOfDivisors = 0;

        for (int num = 1; num <= Math.sqrt(target); num++) {

            if (num * num == target) {
                numberOfDivisors++;
            } else if (target % num == 0) {
                numberOfDivisors += 2;
            }

        }
        return  numberOfDivisors;
    }
}
