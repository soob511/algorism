class Solution {
    static boolean[] visit;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        int cnt = 0;
        dfs(k,dungeons,cnt);
        return answer;
    }
    public void dfs(int k,int[][] dungeons, int cnt){
        for(int i=0;i<dungeons.length;i++){
            if(!visit[i] && dungeons[i][0]<=k){
                visit[i] = true;
                dfs(k-dungeons[i][1],dungeons,cnt+1);
                visit[i] = false;
            }
        }
        answer = Math.max(cnt,answer);
    }
}