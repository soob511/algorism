
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int n = park.length;
        int m = park[0].length();
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(park[i].charAt(j)=='S'){
                    map[i][j]=2;
                    answer[0] = i;
                    answer[1] = j;
                }else if(park[i].charAt(j)=='X'){
                    map[i][j]=1;
                }
            }
        }
        int d = 0;
        for(int i=0;i<routes.length;i++){
             String[] s = routes[i].split(" ");
             if(s[0].equals("N")){
                 d = 0;
             }else if(s[0].equals("S")){
                 d = 1;
             }
             else if(s[0].equals("W")){
                 d = 2;
             }if(s[0].equals("E")){
                 d = 3;
             }
           // System.out.println(s[0]+ " "+s[1]+ d);
            boolean pass = true;
            int nx = 0;
            int ny = 0;
            for(int j=1;j<=Integer.parseInt(s[1]);j++){
                nx = answer[0]+(dx[d]*j);
                ny = answer[1]+(dy[d]*j);
                if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==1){
                    pass = false;
                    continue;
                }
            }
            if(pass){
                answer[0] = nx;
                answer[1] = ny;
            }
            //System.out.println(answer[0] + " "+answer[1]);
        }
        
        
        return answer;
    }
}
