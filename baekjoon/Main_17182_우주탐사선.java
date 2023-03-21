package graph;

import java.io.*;
import java.util.*;

public class Main_17182_우주탐사선 {
    static int n,k;
    static boolean[] visit;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
         map = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int s = 0; s <n; s++) {
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    map[i][j] = Math.min(map[i][j],map[i][s]+map[s][j]);
                }
            }
        }
        visit[k] = true;
        dfs(k,0,0);
        System.out.println(min);
    }

    private static void dfs(int start, int cnt, int sum) {
        if(cnt==n-1){
            min = Math.min(min,sum);
            return;
        }
        for (int i = 0; i <n; i++) {
            if(!visit[i]){
                visit[i] = true;
                dfs(i,cnt+1,sum+map[start][i]);
                visit[i] = false;
            }
        }
    }
}
