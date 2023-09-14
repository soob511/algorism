class Solution {
    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};
    public int solution(int[][] board) {
        int answer = 0;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j =0 ;j<board[0].length;j++){
                if(board[i][j]==1){
                    visit[i][j] = true;
                    for(int d =0;d<8;d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx<0||ny<0||nx>=board.length||ny>=board[0].length)continue;
                        if(!visit[nx][ny]) visit[nx][ny] = true;
                    }
                }
            }
        }
         for(int i=0;i<board.length;i++){
            for(int j =0 ;j<board[0].length;j++){
                if(!visit[i][j])answer++;
            }
        }
        return answer;
    }
}
