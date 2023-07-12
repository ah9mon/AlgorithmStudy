/*
프렌즈 4블록★
* https://school.programmers.co.kr/learn/courses/30/lessons/17679
m : 판의 높이
n : 판의 폭
board : 판의 정보
* */
public class Week4_4 {
//    class Solution {
//        public int solution(int m, int n, String[] board) {
//            int answer = 0;
//
//            // 문자열 배열 -> 2차원 배열
//            char[][] table = new char[m][n];
//            for (int i = 0; i < m; i++) {
//                table[i] = board[i].toCharArray();
//            }
//
//            int cnt = 0;
//            while (true) {
//                boolean[][] removed = new boolean[m][n]; // 제거된 블록
//
//                /* 2X2 블록 일치 */
//                for (int i = 0; i < m - 1; i++) {
//                    for (int j = 0; j < n - 1; j++) {
//                        char cur = table[i][j]; // 현재블록
//                        // 이미 제거된 블록이면
//                        if (cur == ' ') continue;
//                        // 오른쪽,아래,대각선아래
//                        if (cur == table[i][j + 1] &&
//                                cur == table[i + 1][j] &&
//                                cur == table[i][j + 1]) {
//                            removed[i][j] = removed[i][j + 1] = removed[i + 1][j] = removed[i + 1][j + 1] = true;
//                        }
//                    }
//                }
//
//                int totalRemoved = 0; // 제거된 블록의 총 개수
//                /* 제거된 블록 카운팅, 블록제거 */
//                for (int i = 0; i < m; i++) {
//                    for (int j = 0; j < n; j++) {
//                        if (removed[i][j]) {
//                            cnt++;
//                            totalRemoved++;
//                            table[i][j] = ' ';
//                        }
//                    }
//                }
//                if (totalRemoved == 0) break; // 더 이상 제거할 블록이 없으면 반복문 종료
//
//                /* 블록 덜어뜨리기 */
//                for (int j = 0; j < n; j++) {
//                    for (int i = m - 1; i >= 0; i--) {
//                        if (table[i][j] == ' ') {
//                            for (int k = i - 1; k >= 0; k--) {
//                                if (table[k][j] != ' ') {
//                                    table[i][j] = table[k][j];
//                                    table[k][j] = ' ';
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            return cnt;
//        }
//    }

    class Solution {
        public int solution(int m, int n, String[] board) {
            // 주어진 String[] board를 2차원 char 배열로 변환
            char[][] grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                grid[i] = board[i].toCharArray();
            }

            int count = 0; // 제거된 블록의 개수를 카운트하는 변수

            while (true) {
                boolean[][] removed = new boolean[m][n]; // 제거된 블록을 표시하는 배열

                // 2x2 형태의 블록을 찾고 제거
                for (int i = 0; i < m - 1; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        char current = grid[i][j];
                        if (current == ' ') continue; // 이미 제거된 블록은 건너뜀

                        if (current == grid[i][j + 1] && current == grid[i + 1][j] && current == grid[i + 1][j + 1]) {
                            removed[i][j] = true;
                            removed[i][j + 1] = true;
                            removed[i + 1][j] = true;
                            removed[i + 1][j + 1] = true;
                        }
                    }
                }

                int totalRemoved = 0; // 제거된 블록의 총 개수

                // 제거된 블록의 개수를 카운트하고 해당 블록을 공백으로 표시
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (removed[i][j]) {
                            count++;
                            totalRemoved++;
                            grid[i][j] = ' ';
                        }
                    }
                }

                if (totalRemoved == 0) break; // 더 이상 제거할 블록이 없으면 반복문 종료

                // 빈 공간을 위쪽 블록으로 떨어뜨림
                for (int j = 0; j < n; j++) {
                    for (int i = m - 1; i >= 0; i--) {
                        if (grid[i][j] == ' ') {
                            for (int k = i - 1; k >= 0; k--) {
                                if (grid[k][j] != ' ') {
                                    grid[i][j] = grid[k][j];
                                    grid[k][j] = ' ';
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            return count;
        }
    }
}




