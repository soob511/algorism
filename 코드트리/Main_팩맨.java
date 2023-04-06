package Samsung;

import java.util.*;
import java.io.*;

public class Main_팩맨 {
    static ArrayList<Integer>[][] map = new ArrayList[4][4];
    static int m,t;
    static int px,py;
    static Queue<int[]> egg = new LinkedList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] pdx = {-1, 0, 1, 0};
    static int[] pdy = {0, -1, 0, 1};
    static int[][] die = new int[4][4];
    static int[][] pass,select;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        px = Integer.parseInt(st.nextToken()) - 1;
        py = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i <4; i++) {
            for (int j = 0; j <4; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            map[x][y].add(d);
        }

        while (t-->0) {
            //몬스터 복제 시도
            for (int i = 0; i <4; i++) {
                for (int j = 0; j <4; j++) {
                    for (int k = 0; k <map[i][j].size(); k++) {
                        int dir = map[i][j].get(k);
                        egg.add(new int[]{i,j,dir});
                    }
                }
            }

            //몬스터 이동
            ArrayList<Integer>[][] map2 = new ArrayList[4][4];
            for (int i = 0; i <4; i++) {
                for (int j = 0; j <4; j++) {
                    map2[i][j] = new ArrayList<>();
                }
            }
            for (int i = 0; i <4; i++) {
                for (int j = 0; j <4; j++) {
                    for (int k = 0; k <map[i][j].size(); k++) {
                        int dir = map[i][j].get(k);
                        boolean move = false;
                        for (int l = dir; l <dir+8; l++) {
                            int nx = i+dx[l%8];
                            int ny = j+dy[l%8];
                            if(nx<0||ny<0||nx>=4||ny>=4||(nx==px&&ny==py)||die[nx][ny]>0)continue;//범위벗어나거나 팩맨이있는경우 시체 있는 경우
                            move = true;
                            map2[nx][ny].add(l%8);
                            break;
                        }
                        if(!move){ //움직일수 없으면 그대로
                            map2[i][j].add(dir);
                        }
                    }
                }
            }
            map = map2;
            //팩맨 이동
            pass = new int[3][2];
            select = new int[3][2];
            max = -1;
            dfs(px,py,0);
            for (int i = 0; i <3; i++) {
                int x = select[i][0];
                int y = select[i][1];
                if(map[x][y].size()>0){
                    die[x][y] = 3;
                    map[x][y].clear();
                }
            }
            px = select[2][0];
            py = select[2][1];
            //시체소멸
            for (int i = 0; i <4; i++) {
                for (int j = 0; j <4; j++) {
                    if(die[i][j]>0){
                        die[i][j]-=1;
                    }
                }
            }
            //몬스터 복제 완성
            while (!egg.isEmpty()){
               int[] p = egg.poll();
               map[p[0]][p[1]].add(p[2]);
            }

        }
        int answer = 0;
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <4; j++) {
                answer += map[i][j].size();
            }
        }
        System.out.println(answer);

    }

    private static void dfs(int px, int py, int count) {
        if(count==3){
            boolean[][] visit = new boolean[4][4];
            int sum=0;
            for (int i = 0; i <3; i++) {
                if(!visit[pass[i][0]][pass[i][1]]){
                    sum+=map[pass[i][0]][pass[i][1]].size();
                    visit[pass[i][0]][pass[i][1]] = true;
                }
            }
            if(sum>max){
                max = sum;
                for (int i = 0; i <3; i++) {
                    select[i][0] = pass[i][0];
                    select[i][1] = pass[i][1];
                }
            }
            return;
        }
        for(int i=0;i<4;i++){
            int nx = px+pdx[i];
            int ny = py+pdy[i];
            if(nx<0||ny<0||nx>=4||ny>=4)continue;
            pass[count][0] = nx;
            pass[count][1] = ny;
            dfs(nx,ny,count+1);
        }
    }
}
