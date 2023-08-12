import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Repainting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for (int lineNum = 0; lineNum < n; lineNum++) {
            board[lineNum] = br.readLine().toCharArray();
        }
        int minCount = 2500;
        for (int row = 0; row < n - 7; row++) {
            for (int col = 0; col < m - 7; col++) {
                int count = Math.min(countPainting(row, col, 'W', board), countPainting(row, col, 'B', board));
                minCount = Math.min(count, minCount);
            }
        }
        System.out.println(minCount);
    }

    private static int countPainting(int startRow, int startCol, char startColor, char[][] board) {
        int count = 0;
        char color = startColor;
        for (int row = startRow; row < startRow + 8; row++) {
            for (int col = startCol; col < startCol + 8; col++) {
                if (color != board[row][col]) {
                    count++;
                }
                color = changeColor(color);
            }
            color = changeColor(color);
        }
        return count;
    }

    private static char changeColor(char color) {
        if (color == 'W') {
            return 'B';
        } else {
            return 'W';
        }
    }
}
