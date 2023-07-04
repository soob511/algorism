package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_1743_음식물피하기 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m,k;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for(int i=0;i<k;i++){
            st =new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(map[i][j]==1&&!visit[i][j]){
                    bfs(i,j);
                }
            }
        }
        System.out.println(max);

//        for (int[] b:map) System.out.println(Arrays.toString(b));
//        System.out.println();
    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        visit[a][b] = true;
        int count = 1;
        while (!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<=0||ny<=0||nx>n||ny>m||visit[nx][ny])continue;
                if(map[nx][ny]==1){
                    q.add(new int[]{nx,ny});
                    visit[nx][ny]=true;
                    count++;
                }
            }
        }
        max = Math.max(max,count);
    }
}
