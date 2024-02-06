class Solution {
    public int solution(int n) {
        int answer = 0;
        int[][] dp = new int[1][n+1];
        dp[0][1] = 1;
        dp[0][2] = 2;
        for(int i=3;i<=n;i++){
            dp[0][i] = (dp[0][i-1]+dp[0][i-2])%1000000007;
        }
        return dp[0][n];
    }
}
