package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2606_바이러스 {
    static int[][] map;
    static boolean[] visit;
    static int n,m;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
         m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        bfs(1);
        System.out.println(count);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()){
            int x = q.poll();

            for(int i=1;i<=n;i++){
                if(map[x][i]==1&&!visit[i]){
                    q.add(i);
                    visit[i]=true;
                    count++;
                }
            }
        }
    }
}
