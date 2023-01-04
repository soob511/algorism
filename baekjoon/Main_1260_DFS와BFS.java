package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS {
    static int[][] map;
    static boolean[] visit;
    static int n,m,v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        visit = new boolean[n+1];
        dfs(v);
        System.out.println();
        bfs(v);
    }

    private static void dfs(int v) {
        visit[v] = true;
        System.out.print(v+" ");
        for(int j=1;j<=n;j++){
            if(map[v][j]==1){
                if(!visit[j]){
                    dfs(j);
                }
            }
        }
    }

    private static void bfs(int v) {
        visit = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x+" ");
            for(int j=1;j<=n;j++){
                if(map[x][j]==1){
                    if(!visit[j]){
                        q.add(j);
                        visit[j] = true;
                    }
                }
            }

        }
    }
}


