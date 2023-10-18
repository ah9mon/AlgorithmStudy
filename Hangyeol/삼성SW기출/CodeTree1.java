import java.util.*;
import java.io.*;
import java.lang.Math;

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CodeTree1 {

    private static int N;
    private static int M;
    private static int[][] maze;
    private static Deque<Coordinate> people;
    private static Coordinate exit;
    private static Coordinate square;
    private static int squareLen; // 최소정사각형 변 길이
    private static int count; // 이동 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M, K 입력받기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        // 미로 입력 받기
        maze = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maze[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 참가자 위치 입력 받기
        people = new ArrayDeque<>();
        for (int k = 0; k < M; k++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st3.nextToken()) - 1;
            int x = Integer.parseInt(st3.nextToken()) - 1;
            people.add(new Coordinate(x, y));
        }

        // 출구 위치 입력 받기
        StringTokenizer st4 = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st4.nextToken()) - 1;
        int x = Integer.parseInt(st4.nextToken()) - 1;
        exit = new Coordinate(x, y);

        for (int sec = 1; sec <= K; sec++) {
            // 사람 이동
            move();

            // 모두 탈출했는지?
            if (people.isEmpty()) break;

            // 최소 정사각형 찾기
            findMinSquare();

            // 회전
            rotate();
        }

        System.out.println(count);
        System.out.println((exit.y + 1) + " " + (exit.x + 1));
    }

    private static void rotate() {
        int sx = square.x;
        int sy = square.y;
        int n = squareLen;

        // 벽 회전
        int[][] newMaze = new int[N][N];
        for (int r = sy; r < sy + n; r++) {
            for (int c = sx; c < sx + n; c++) {
                if (maze[r][c] > 0) {
                    Coordinate rotatedCoor = getRotatedCoordinate(c, r);
                    newMaze[rotatedCoor.y][rotatedCoor.x] = maze[r][c] - 1;
                }
            }
        }

        // 회전한 값 갱신
        for (int r = sy; r < sy + n; r++) {
            for (int c = sx; c < sx + n; c++) {
                maze[r][c] = newMaze[r][c];
            }
        }

        // 사람 회전
        Deque<Coordinate> newDeque = new ArrayDeque<>();
        while (!people.isEmpty()) {
            Coordinate person = people.pollFirst();
            // 사각형 안에 있는지 ?
            if (sx <= person.x && person.x < sx + n && sy <= person.y && person.y < sy + n) {
                // 회전
                newDeque.add(getRotatedCoordinate(person.x, person.y));
            } else {
                newDeque.add(person);
            }
        }
        people = newDeque;

        // 출구 회전
        exit = getRotatedCoordinate(exit.x, exit.y);
    }

    private static Coordinate getRotatedCoordinate(int x, int y) {
        y -= square.y;
        x -= square.x;
        return new Coordinate(squareLen - y - 1 + square.x , x + square.y);
    }

    private static void findMinSquare() {
        int n = 2;
        while(true) {
            for (int r = 0; r < N-n; r++) {
                for (int c = 0; c < N-n; c++) {
                    // 사람 있는지 확인
                    boolean isIn = false;
                    for (Coordinate person : people) {
                        // 정사각형 범위 안에 사람 있는지 체크
                        if (c <= person.x && person.x < c + n && r <= person.y && person.y < r + n) {
                            isIn = true;
                            break;
                        }
                    }

                    // 사람 있으면 출구 있는지 확인
                    if (isIn) {
                        if (c <= exit.x && exit.x < c + n && r <= exit.y && exit.y < r + n) {
                            squareLen = n;
                            square = new Coordinate(c,r);
                            return;
                        }
                    }
                }
            }
            n++;
        }
    }

    private static void move() {
        // 상하좌우
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};

        Deque<Coordinate> newDeque = new ArrayDeque<>();
        while (!people.isEmpty()) {
            Coordinate person = people.pollFirst();
            boolean flag = true;
            // 상하좌우 탐색
            if (person.y != exit.y) {
                if (person.y > exit.y) {
                    // 위
                    int nx = person.x + dx[0];
                    int ny = person.y + dy[0];
                    if (canMove(person, nx, ny)) {
                        count++;
                        newDeque.add(new Coordinate(nx, ny));
                        flag = false;
                    }
                } else {
                    // 아래
                    int nx = person.x + dx[1];
                    int ny = person.y + dy[1];
                    if (canMove(person, nx, ny)) {
                        count++;
                        newDeque.add(new Coordinate(nx, ny));
                        flag = false;
                    }
                }
            }

            if (flag) {
                if (person.x != exit.x) {
                    if (person.x > exit.x) {
                        // 좌
                        int nx = person.x + dx[2];
                        int ny = person.y + dy[2];
                        if (canMove(person, nx, ny)) {
                            count++;
                            newDeque.add(new Coordinate(nx, ny));
                            flag = false;
                        }
                    } else {
                        // 우
                        int nx = person.x + dx[3];
                        int ny = person.y + dy[3];
                        if (canMove(person, nx, ny)) {
                            count++;
                            newDeque.add(new Coordinate(nx, ny));
                            flag = false;
                        }
                    }
                }

                if (flag) {
                    newDeque.add(person);
                }
            }
        }
        people = newDeque;
    }

    private static boolean canMove(Coordinate person, int nx, int ny) {
        int x = person.x;
        int y = person.y;

        if (isInRange(nx, ny) && maze[ny][nx] == 0) { // 범위 확인

            int nowToExit = Math.abs(exit.x - x) + Math.abs(exit.y - y);
            int nextToExit = Math.abs(exit.x - nx) + Math.abs(exit.y - ny);

            return nowToExit > nextToExit;
        }

        return false;
    }

    private static boolean isInRange(int x, int y) {
        return 0<= x && x < N && 0 <= y && y < N;
    }
}