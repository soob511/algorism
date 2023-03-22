package backtracking;

import java.io.*;
import java.util.*;

public class Main_15650_N과M2 {
    static int n,m;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         visit = new boolean[n];
         dfs(0,0);

    }

    private static void dfs(int cnt,int start) {
        if(cnt==m){
            for (int i = 0; i <n; i++) {
                if(visit[i]){
                    System.out.print(i+1+" ");
                }
            }
            System.out.println();
        }
        for (int i = start; i <n; i++) {
            if(!visit[i]){
                visit[i] = true;
                dfs(cnt+1,i+1);
                visit[i] = false;
            }
        }
    }
}
