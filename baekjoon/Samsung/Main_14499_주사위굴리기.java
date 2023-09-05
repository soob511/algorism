package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_14499_주사위굴리기 {
    static int[] dx = {0, 0, -1, 1}; // 동 서 북 남
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dice = new int[4][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int d = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {//범위 벗어나지 않으면 주사위 굴림
                if (d == 0) {//동
                    int temp = dice[1][2];
                    dice[1][2] = dice[1][1];
                    dice[1][1] = dice[1][0];
                    dice[1][0] = dice[3][1];
                    dice[3][1] = temp;
                } else if (d == 1) {//서
                    int temp = dice[1][0];
                    dice[1][0] = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = dice[3][1];
                    dice[3][1] = temp;
                } else if (d == 2) {//북
                    int temp = dice[0][1];
                    for (int i = 0; i < 3; i++) dice[i][1] = dice[i + 1][1];
                    dice[3][1] = temp;
                } else {//남
                    int temp = dice[3][1];
                    for (int i = 3; i >= 1; i--) {
                        dice[i][1] = dice[i - 1][1];
                    }
                    dice[0][1] = temp;
                }
                if(map[nx][ny]==0){
                    map[nx][ny] = dice[3][1];
                }else{
                    dice[3][1] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                x= nx;
                y = ny;
                System.out.println(dice[1][1]);
            }

        }

    }
}
