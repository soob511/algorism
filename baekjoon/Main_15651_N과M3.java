package backtracking;

import java.io.*;
import java.util.*;

public class Main_15651_N과M3 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int cnt) {
        if(cnt==m){
            for (int i = 0; i <m; i++) {
                sb.append(arr[i] +" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <=n; i++) {
           arr[cnt] = i;
           dfs(cnt+1);
        }
    }
}
