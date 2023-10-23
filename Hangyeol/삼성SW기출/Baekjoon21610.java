import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon21610 {


    static class MapInfo {
        int[][] waterMount;
        int[][] clouds;

        public MapInfo () {
            this.waterMount = new int[N][N];
            this.clouds = new int[N][N];
            setInitClouds();
        }

        public void setInitClouds() {
            this.clouds[N-1][0] = 1;
            this.clouds[N-1][1] = 1;
            this.clouds[N-2][0] = 1;
            this.clouds[N-2][1] = 1;
        }

        public void setWaterMount(int r, int c,int mount) {
            this.waterMount[r][c] = mount;
        }

        public void createNewCloud() {
            int[][] newClouds = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (this.waterMount[r][c] >= 2 && this.clouds[r][c] == 0) {
                        newClouds[r][c] = 1;
                        this.waterMount[r][c] -= 2;
                    }
                }
            }

            this.clouds = newClouds;
        }

        public void moveCloud(int dx, int dy, int s) {
            int[][] movedCloud = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (this.clouds[r][c] == 1) {
                        int newC = move(c, dx, s);
                        int newR = move(r, dy, s);
                        movedCloud[newR][newC] = 1;
                    }
                }
            }

            this.clouds = movedCloud;
        }

        private static int move(int now, int d, int s) {
            int distance = d * s;
            distance = (distance < 0) ? -(-distance % N) : distance % N;
            if (distance + now < 0) {
                return distance + now + N;
            } else if (distance + now >= N) {
                return distance + now - N;
            } else {
                return distance + now;
            }
        }

        public void waterCopyBug() {
            int[] dx = new int[]{-1,1,-1,1};
            int[] dy = new int[]{-1,1,1,-1};
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int count = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = c + dx[i];
                        int ny = r + dy[i];
                        if (this.clouds[r][c] == 1 && 0 <= nx && nx < N && 0 <= ny && ny < N && this.waterMount[ny][nx] >= 1) {
                            count++;
                        }
                    }
                    this.waterMount[r][c] += count;
                }
            }
        }
    }



    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        MapInfo mapInfo = new MapInfo();
        for (int r = 0; r < N; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int mount = Integer.parseInt(st2.nextToken());
                mapInfo.setWaterMount(r, c, mount);
            }
        }

        int[] dx = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st3.nextToken());
            int s = Integer.parseInt(st3.nextToken());
            // 구름 이동
            mapInfo.moveCloud(dx[d], dy[d], s);

            // 비 내리기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (mapInfo.clouds[r][c] == 1) {
                        mapInfo.waterMount[r][c] += 1;
                    }
                }
            }

            // 물복사 버그
            mapInfo.waterCopyBug();

            // 새 구름 생성
            mapInfo.createNewCloud();
        }

        int sum = 0;
        for (int r= 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sum += mapInfo.waterMount[r][c];
            }
        }

        System.out.println(sum);
    }
}
