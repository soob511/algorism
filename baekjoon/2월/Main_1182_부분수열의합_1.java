package backtracking;

import java.io.*;
import java.util.*;

public class Main_1182_부분수열의합 {
    static  int n,s;
    static int[] arr;
    static boolean[] visit;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         s = Integer.parseInt(st.nextToken());

         arr = new int[n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        com(0);
        if(s==0){
            System.out.println(cnt-1);
        }else{
            System.out.println(cnt);
        }
    }

    private static void com(int i) {
        if(i==n){
            int sum=0;
            for (int j = 0; j <n; j++) {
                if(visit[j]){
                    sum+=arr[j];
                }
            }
            if(sum==s){
                cnt++;
            }
            return;
        }
        visit[i] = true;
        com(i+1);
        visit[i] = false;
        com(i+1);
    }
}
