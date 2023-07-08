import java.util.Arrays;

public class KakaoLv1 {

    public int solution(int m, int n, String[] board) {

        int answer = 0; // 총 삭제된 블럭의 개수
        int deleteCount = 0; // 1회 탐색당 삭제된 블럭의 개수

        // col, row 뒤집은 Array 생성 , 이제 왼쪽에서 오른쪽이동이 떨어지는 것과 같아짐
        char[][] newBoard = changeRowToColumn(board, m, n);

        while (true) {
            int[][] checkSquare = new int[n][m];

            // 블록 지우기
            deleteCount = deleteBlocks(newBoard, checkSquare, n, m);
            if (deleteCount == 0) break; // 삭제된게 없으면 종료
            answer += deleteCount;

            // board 재정렬
            rebuildBoard(newBoard, checkSquare, n, m);
        }

        return answer;
    }

    private static void rebuildBoard(char[][] board,int[][] checkSquere,int n, int m) {
        // 빈공간 있으면 왼쪽에서 오른쪽으로 떙기기
        for (int row = 0; row < n; row++) {
            int count = 0; // 빈공간 카운트
            for (int column = m - 1; column >= 0; column--) {
                if (checkSquere[row][column] == 1) {// 삭제됐으면
                    count++;
                    board[row][column] = ' ';
                } else {
                    if (count > 0) {
                        board[row][column + count] = board[row][column];
                        board[row][column] = ' ';
                    }
                }
            }
        }
    }

    private static int deleteBlocks(char[][] board,int[][] checkSquare,int n , int m) {

        int[] dx = {0, 1, 1, 0};
        int[] dy = {0, 0, 1, 1};

        // 탐색 시작
        int deleteCount = 0;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                char charValue = board[row][column];
                if (charValue == ' ') continue; // 삭제된 부분이면 다음으로
                boolean flag = true;

                //탐색
                for (int index = 0; index < 4; index++) {
                    int nx = column + dx[index];
                    int ny = row + dy[index];

                    if ((nx >= 0 && nx < m) && (ny >= 0 && ny < n)) { // 범위안에 있는지 체크
                        if (charValue != board[ny][nx]) { // 같은 값이 아니면
                            flag = false;
                            break; // 다르면 square 안되므로 탈출
                        }
                    } else { // 범위 밖이면
                        flag = false;
                        break;
                    }
                }

                // delete된 블럭 count하기
                if (flag) { // Square완성되면 삭제 체크
                    for (int index2 = 0; index2 < 4; index2++) {
                        int nx2 = column + dx[index2];
                        int ny2 = row + dy[index2];
                        if (checkSquare[ny2][nx2] == 0) { // 삭제 count안했으면
                            checkSquare[ny2][nx2] = 1;
                            deleteCount++;
                        }
                    }
                }
            }
        }
        return deleteCount;
    }



    private static char[][] changeRowToColumn (String[] originalBoard, int m, int n) {
        // 값 변경 및 탐색을 Y -> X 로 하는 것이 X -> Y 방향 탐색보다 빠르기 때문에
        // Row와 Column 값을 바꾼 형태의 Board 생성
        // 이렇게 바꾸면 왼쪽에서 오른쪽으로 이동하는 것이 떨어지는 방향과 같아짐
        char[][] board = new char[n][m];
        for (int col = 0; col < n; col++) {
            char[] line = new char[m];
            for (int row = 0; row < m; row++) {
                line[row] = originalBoard[row].charAt(col);
            }
            board[col] = line;
        }
        return board;
    }
}
