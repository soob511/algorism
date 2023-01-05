package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2644_촌수계산 {
    static int[][] map;
    static int start,end,n,m;
    static boolean[] visit;
    static int count;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
         start = Integer.parseInt(st.nextToken());
         end = Integer.parseInt(st.nextToken());

         m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        dfs(start,0);
        System.out.println(result);
    }

    private static void dfs(int x, int count) {
        visit[x] = true;
        if(x==end){
            result = count;
            return;
        }
        for(int i=1;i<=n;i++){
            if(map[x][i]==1&&!visit[i]){
                dfs(i, count+1);
            }
        }
    }

}
