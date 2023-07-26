package 삼성하반기준비;

import java.io.*;
import java.util.*;
public class Main_16234_인구이동_2 {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean move = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            visit = new boolean[n][n];
            move = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if (!move) {
                break;
            }else{
                day++;
            }
        }
        System.out.println(day);

    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> mq = new LinkedList<>();
        visit[a][b] = true;
        q.add(new int[]{a, b});
        mq.add(new int[]{a, b});
        int sum = map[a][b];
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && Math.abs(map[x][y] - map[nx][ny]) >= l && Math.abs(map[x][y] - map[nx][ny]) <= r && !visit[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    mq.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    sum += map[nx][ny];
                    move = true;
                }
            }
        }
        int size = mq.size();
        while (!mq.isEmpty()) {
            int[] p = mq.poll();
            map[p[0]][p[1]] = sum / size;
        }
    }
}
