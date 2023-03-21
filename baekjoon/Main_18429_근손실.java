package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18429_근손실 {
    static int n,k;
    static int[] weight;
    static boolean[] visit;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
         weight = new int[n];
         visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,500);
        System.out.println(count);
    }

    private static void dfs(int cnt,int sum) {
        if(cnt==n){
            count++;
            return;
        }
        for (int i = 0; i <n; i++) {
            if(sum+weight[i]-k>=500&&!visit[i]){
                visit[i] = true;
                dfs(cnt+1,sum+weight[i]-k);
                visit[i] = false;
            }
        }
    }
}
