package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2502_떡먹는호랑이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

       int[] dp = new int[k+1];
        for (int i = 1; i <=k/2; i++) {
            dp[0] = i;
            for (int j = i+1; j <k; j++) {
                dp[1] = j;
                for (int l = 2; l <d; l++) {
                    dp[l] = dp[l-1]+dp[l-2];
                }
                if(dp[d-1]==k){
                    System.out.println(dp[0]);
                    System.out.println(dp[1]);
                    System.exit(0);
                }
            }
        }


    }
}
