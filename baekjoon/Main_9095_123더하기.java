package DP;

import java.io.*;

public class Main_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i <tc; i++) {
            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            int n = Integer.parseInt(br.readLine());
            for (int j = 4; j <=n; j++) {
                dp[j] = dp[j-3]+dp[j-2]+dp[j-1];
            }
                System.out.println(dp[n]);
        }
    }
}
