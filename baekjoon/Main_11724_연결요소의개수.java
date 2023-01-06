package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_11724_연결요소의개수 {
    static boolean[] visit;
    static int[][] map;
    static int n,m;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        map = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        for(int i=1;i<=n;i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x) {
        visit[x] = true;
        for(int i=1;i<=n;i++){
            if(map[x][i]==1&&!visit[i]){
                dfs(i);
            }
        }
    }
}
