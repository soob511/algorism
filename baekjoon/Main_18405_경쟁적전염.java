package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_18405_경쟁적전염 {
    static int X,Y;
    static int n,k,s;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        Y = Integer.parseInt(st.nextToken())-1;

        while (s-->0){
            visit = new boolean[n][n];
            for(int m =1;m<=k;m++){
                for (int i = 0; i <n; i++) {
                    for (int j = 0; j <n; j++) {
                        if(map[i][j]==m&&!visit[i][j]){
                            dfs(i,j);
                        }
                    }
                }
            }
            if(map[X][Y]>0)break;
        }
        System.out.println(map[X][Y]);

    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||ny<0||nx>=n||ny>=n||visit[nx][ny])continue;
            if(map[nx][ny]==0){
                visit[nx][ny] = true;
                map[nx][ny] = map[x][y];
            }
        }
    }
}
