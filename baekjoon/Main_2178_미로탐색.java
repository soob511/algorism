package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2178_미로탐색 {
    static int[][] map;
    static int[][] count;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        count = new int[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for (int j=0;j<m;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
//        for(int[] b:map) System.out.println(Arrays.toString(b));
//        System.out.println();

        bfs(0,0);
        System.out.println(count[n-1][m-1]);
    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        count[a][b]=1;

        while (!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for(int i=0;i<4;i++){

                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(nx<0||ny<0||nx>=n||ny>=m)continue;
                    if(count[nx][ny]!=0||map[nx][ny]!=1) continue;
                    q.add(new int[]{nx,ny});
                    count[nx][ny] = count[x][y]+1;

            }
        }
    }


}
