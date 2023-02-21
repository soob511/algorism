package backtracking;

import java.io.*;
import java.util.*;

public class Main_1182_부분수열의합_2{
    static  int n,s;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        if(s==0){
            System.out.println(count-1);
        }else{
            System.out.println(count);
        }
    }

    private static void dfs(int cnt, int sum) {
        if(cnt==n){
            if(sum==s){
                count++;
            }
            return;
        }
        dfs(cnt+1,sum+arr[cnt]);
        dfs(cnt+1,sum);
    }


}
