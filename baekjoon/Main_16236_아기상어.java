package implement;

import java.util.*;
import java.io.*;

public class Main_16236_아기상어 {
    static int n;
    static int[][] map;
    static int[][] road;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int size;
    static int fx,fy;
    static int time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
         map = new int[n][n];

        //맵 입력
        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    map[i][j]= -1;
                    fx = i;
                    fy = j;
                }
            }
        }

        size =2;
        int cnt = 0;
        while (true){
            int min = Integer.MAX_VALUE;
            int mx = 0;
            int my = 0;
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    if(map[i][j]>0&&map[i][j]<size){
                        road = new int[n][n];
                        roadmin(i,j);
//                        for(int[]b:road) System.out.println(Arrays.toString(b));
//                        System.out.println();
                        if(road[fx][fy]>0&&road[fx][fy]<min){
                            min = road[fx][fy];
                            mx = i;
                            my = j;
                        }
                    }
                }
            }
            if(min == Integer.MAX_VALUE){
                break;
            }
            time += min;
            map[mx][my] = map[fx][fy];
            map[fx][fy] = 0;
            fx = mx;
            fy = my;
            cnt++;
            if(cnt==size){
                size++;
                cnt=0;
            }

        }
        System.out.println(time);

    }

    private static void roadmin(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        while (!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i <4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0||ny<0||nx>=n||ny>=n||map[nx][ny]>size||road[nx][ny]!=0) continue;
                road[nx][ny] = road[x][y]+1;
                q.add(new int[]{nx,ny});
            }
        }
    }

}
