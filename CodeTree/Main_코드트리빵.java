package Samsung;

import java.util.*;
import java.io.*;

public class Main_코드트리빵 {
    static int n, m;
    static int[][] map;
    static int[][] store;
    static Queue<int[]>[] people;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] move;
    static int end=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        move = new boolean[m+1][n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        store = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            store[i][0] = x;
            store[i][1] = y;
        }

        people = new LinkedList[m + 1];
        for (int i = 1; i <= m; i++) {
            people[i] = new LinkedList<>();
        }

        int time = 0;
        for (int i = 1; i <= m; i++) {
            time++;
            go();
            basecamp(i);
        }
        while (true){
            time++;
            go();
            if(end==m){
                break;
            }
        }
        System.out.println(time);

    }

    private static void go() {
        for (int i = 1; i <=m; i++) {
            if(!people[i].isEmpty()){
                int size = people[i].size();
                all :
                while (size-->0){
                    int[] p = people[i].poll();
                    int x = p[0];
                    int y = p[1];
                    for (int j = 0; j <4; j++) {
                        int nx = x+dx[j];
                        int ny = y+dy[j];
                        if(nx<0||ny<0||nx>=n||ny>=n||map[nx][ny]<0||move[i][nx][ny])continue;
                        if(nx==store[i][0]&&ny==store[i][1]){
                            end++;
                            map[nx][ny]=-1;
                            people[i].clear();
                            break all;
                        }
                        move[i][nx][ny] = true;
                        people[i].add(new int[]{nx,ny});
                    }
                }
            }
        }
    }

    private static void basecamp(int v) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{store[v][0], store[v][1]});
        boolean[][] visit = new boolean[n][n];
        visit[store[v][0]][store[v][1]] = true;

        int mx = Integer.MAX_VALUE;
        int my = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean base = false;

            while (size-- > 0) {

                int[] p = q.poll();
                int x = p[0];
                int y = p[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || visit[nx][ny] || map[nx][ny] < 0) continue;//범위밖이거나 방문했거나 이미확정된베이스캠프
                    if (map[nx][ny] == 1) {
                        base = true;
                        if(x<mx){
                            mx = nx;
                            my = ny;
                        }else if(nx==mx && ny<my){
                            my = ny;
                        }
                        continue;
                    }
                    visit[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
            if(base){
                break;
            }
        }
        map[mx][my] = -1;
        people[v].add(new int[]{mx,my});
        move[v][mx][my] = true;
    }
}
