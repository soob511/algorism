package Samsung;

import java.io.*;
import java.util.*;

public class Main_15684_사다리조작 {
    static int n, m, h;
    static int[][] map;
    static int[] dy = {-1, 1};
    static int answer;
    static boolean finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(0);
            if (finish) break;
        }
        System.out.println(finish ? answer : -1);
    }

    private static void dfs(int cnt) {
        if (finish) return;
        if (answer == cnt) {
            if (check()) finish = true;
            return;
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(cnt + 1);
                    map[i][j] = map[i][j + 1] = 0;

                }

            }

        }
    }

    private static boolean check() {
        for (int i = 1; i <= n; i++) {
            int x = 1;
            int y = i;
            for (int j = 0; j < h; j++) {
                if (map[x][y] == 1) y++;
                else if (map[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
    }
}
