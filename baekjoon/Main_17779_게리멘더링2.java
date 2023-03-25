package Samsung;

import java.io.*;
import java.util.*;

public class Main_17779_게리멘더링2 {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int answer = Integer.MAX_VALUE;
    static int all;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                all += map[i][j];
            }
        }
        for (int x = 1; x <=n; x++) {
            for (int y = 1; y <=n; y++) {
                for (int d1 = 1; d1 <=n; d1++) {
                    for (int d2 = 1; d2 <=n; d2++) {
                        if(x+d1+d2>n)continue;
                        if(1>y-d1)continue;
                        if(y+d2>n)continue;
                        division(x,y,d1,d2);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void division(int x, int y, int d1, int d2) {
        visit = new boolean[n + 1][n + 1];
        //5구역
        for (int i = 0; i <= d1; i++) {
            visit[x + i][y - i] = true;
            visit[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            visit[x + i][y + i] = true;
            visit[x + d1 + i][y - d1 + i] = true;
        }
        int[] sum = new int[5];
        //1구역
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (visit[i][j]) break;
                sum[0] += map[i][j];
            }
        }
        //2구역
        for (int i = 1; i <= x + d2; i++) {
            for (int j = n; j >y; j--) {
                if (visit[i][j]) break;
                sum[1] += map[i][j];
            }

        }
        //3구역
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (visit[i][j]) break;
                sum[2] += map[i][j];
            }

        }
        //4구역
        for (int i = x + d2 + 1; i <= n; i++) {
            for (int j =n; j >=y-d1+d2; j--) {
                if (visit[i][j]) break;
                sum[3] += map[i][j];
            }
        }
        sum[4] = all;
        for (int i = 0; i <4; i++) {
            sum[4] -= sum[i];
        }

        Arrays.sort(sum);

        answer = Math.min(answer,sum[4]-sum[0]);
    }
}

