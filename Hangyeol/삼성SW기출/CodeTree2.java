import java.util.*;
import java.io.*;

//class Coordinate {
//    int x;
//    int y;
//
//    public Coordinate(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

class Tank implements Comparable<Tank> {
    int x;
    int y;
    int r;
    int p;

    public Tank (int x, int y, int r, int p) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.p = p;
    }

    public int compareTo(Tank tank) {
        if (this.p != tank.p) return this.p - tank.p;
        if (this.r != tank.r) return tank.r - this.r;
        if (this.x + this.y != tank.x + tank.y) return (tank.x + tank.y) - (this.x + this.y);
        return tank.x - this.x;
    }

}

public class CodeTree2 {

    private static int N;
    private static int M;
    private static int[][] tanks;
    private static int[][] res;
    private static List<Tank> activatedTank = new LinkedList();
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        tanks = new int[N][M];
        res = new int[N][M];
        for (int r = 0; r < N; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                tanks[r][c] = Integer.parseInt(st2.nextToken());
                if (tanks[r][c] > 0) activatedTank.add(new Tank(c, r, 0, tanks[r][c]));
            }
        }

        for (int k = 1; k <= K; k++) {
            if (activatedTank.size() <= 1) break;

            Collections.sort(activatedTank);

            //1
            Tank weekTank = activatedTank.get(0);
            System.out.println("week : " + weekTank.x + " " + weekTank.y);
            tanks[weekTank.y][weekTank.x] += N + M;
            res[weekTank.y][weekTank.x] = k;

            //2 & 3
            Tank strongTank = activatedTank.get(activatedTank.size() - 1);
            System.out.println("strong : " + strongTank.x + " " + strongTank.y);
            if (!lazer(weekTank, strongTank)) bomb(weekTank, strongTank);

            System.out.println("공격 후");
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    System.out.print(tanks[r][c] + " ");
                }
                System.out.println();
            }

            System.out.println("연관있는거");
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    System.out.print(visited[r][c] + " ");
                }
                System.out.println();
            }

            // 4
            // 공격에 무관햇던 포탑 공격력 증가
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (visited[r][c] == 0 && tanks[r][c] > 0) {
                        tanks[r][c] += 1;
                    }
                }
            }

            // System.out.println("증가 후");
            // for (int r = 0; r < N; r++) {
            //     for (int c = 0; c < M; c++) {
            //         System.out.print(tanks[r][c] + " ");
            //     }
            //     System.out.println();
            // }

            // 활성화 된 탱크 재정리
            activatedTank = new LinkedList();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (tanks[r][c] > 0) {
                        activatedTank.add(new Tank(c, r, res[r][c], tanks[r][c]));
                    }
                }
            }
        }

        Collections.sort(activatedTank);
        System.out.println(activatedTank.get(activatedTank.size() - 1).p);
    }

    private static void bomb(Tank start, Tank target) {
        visited = new int[N][M];
        visited[start.y][start.x] = 1;
        int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};

        // 주변
        for (int v = 0; v < 8; v++) {
            int nx = next(target.x + dx[v], M);
            int ny = next(target.y + dy[v], N);
            if (tanks[ny][nx] != 0 && !(start.x == nx && start.y == ny)) {
                attack(start, nx, ny, false);
                visited[ny][nx] = 1;
            }
        }

        // 타겟
        visited[target.y][target.x] = 1;
        attack(start, target.x, target.y, true);
    }

    private static boolean lazer(Tank start, Tank target) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        visited = new int[N][M];

        Deque<Coordinate> q = new ArrayDeque();
        q.add(new Coordinate(start.x, start.y));
        visited[start.y][start.x] = 1;
        while(!q.isEmpty()) {
            Coordinate now = q.pollFirst();

            if (target.x == now.x && target.y == now.y) break;

            for (int v = 0; v < 4; v++) {
                int nx = next(now.x + dx[v], M);
                int ny = next(now.y + dy[v], N);
                if (tanks[ny][nx] != 0 && visited[ny][nx] == 0) {
                    q.add(new Coordinate(nx, ny));
                    visited[ny][nx] = visited[now.y][now.x] + 1;
                }
            }
        }

        // 갈 수 있으면
        if (visited[target.y][target.x] != 0) {
            int[][] newVisited = new int[N][M];
            // 경로 탐색
            int x = target.x;
            int y = target.y;
            attack(start, x, y, true);
            newVisited[y][x] = 1;
            while(true) {

                for (int v = 3; v >= 0; v--) {
                    int nx = next(x + dx[v], M);
                    int ny = next(y + dy[v], N);
                    if (visited[ny][nx] == visited[y][x] - 1) {
                        x = nx;
                        y = ny;
                        break;
                    }
                }

                newVisited[y][x] = 1;
                if (x == start.x && y == start.y) {
                    break;
                } else {
                    attack(start, x, y, false);
                }
            }
            visited = newVisited;
            return true;
        }
        // 갈 수 없으면
        return false;
    }

    private static void attack(Tank start, int x, int y, boolean isTarget) {
        int power = tanks[y][x];
        power -= (isTarget) ? tanks[start.y][start.x] : tanks[start.y][start.x]/2;
        if (power < 0) {
            tanks[y][x] = 0;
        } else {
            tanks[y][x] = power;
        }
    }

    private static int next(int n, int limit) {
        if (n == -1) {
            return limit - 1;
        } else if (n == limit) {
            return 0;
        } else {
            return n;
        }
    }
}