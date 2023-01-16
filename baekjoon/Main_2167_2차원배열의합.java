package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2167_2차원배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];

        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int s = 0; s <k; s++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int i = I; i <=x; i++) {
                for (int j = J; j <=y; j++) {
                    sum += map[i][j];
                }
            }
            System.out.println(sum);
        }

    }

}
