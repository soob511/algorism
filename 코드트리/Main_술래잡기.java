package Samsung;

import java.util.*;
import java.io.*;

public class Main_술래잡기 {
    static int[] dx = {0, 1, 0, -1};//우 하 좌 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());//도망자
        int h = Integer.parseInt(st.nextToken());//나무
        int k = Integer.parseInt(st.nextToken());//반복

        int[][] map = new int[n][n];
        int[][] tree = new int[n][n];
        ArrayList<Integer>[][] person = new ArrayList[n][n];

        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                map[i][j] = -1;
            }
        }

        int mx = n / 2;
        int my = n / 2;
        map[mx][my] = 3;//술래 가운데서 시작 방향 상
        int md = 1;//중심부터

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                person[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1; // 0이면 우좌, 1이면 하상
            person[x][y].add(d);
        }

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            tree[x][y] = 1;
        }
        int score = 0;
        int turn = 1;
        int go=0;
        int up = 0;
        int size = 0;
        while ( true) {
            size++;
            //도망자 움직임 술래와의 거리 3이하인 도망자만
            ArrayList<Integer>[][] person2 = new ArrayList[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    person2[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < person[i][j].size(); l++) {
                        if (Math.abs(mx - i) + Math.abs(my - j) <= 3) {
                            int dir = person[i][j].get(l);
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                             if (nx < 0 || ny < 0 || nx >= n || ny >= n) {//범위밖이면
                                dir = (dir + 2) % 4;//반대방향
                                nx = i + dx[dir];
                                ny = j + dy[dir];
                                if(map[nx][ny]==-1){//술래가 없다면
                                    person2[nx][ny].add(dir);
                                }else{
                                    person2[i][j].add(dir);
                                }
                            }else if (nx >= 0 && ny >= 0 && nx < n && ny < n) {//범위 안이라면
                                 if(map[nx][ny]==-1){//술래가 없다면
                                     person2[nx][ny].add(dir);
                                 }else{
                                     person2[i][j].add(dir);
                                 }
                            }
                        }
                        else{
                            int dir = person[i][j].get(l);
                            person2[i][j].add(dir);
                        }
                    }
                }
            }
            person = person2;
            //술래이동
            if(md==1){//시계방향 이동
                int dir = map[mx][my];
                map[mx][my] = -1;
                mx = mx+dx[dir];
                my = my+dy[dir];
                go++;
                if(go==turn){
                    go=0;
                    up++;
                    dir = (dir+1)%4;
                }
                if(up==2){
                    up=0;
                    turn++;
                }
                map[mx][my] = dir;
                if(mx==0&&my==0){//끝에 도달하면 반시계
                    dir = (dir+2)%4;
                    map[mx][my] = dir;
                    md=2;
                    turn = n-1;
                    up=0;
                    go=0;
                }
            }
            else{//반시계방향
                int dir = map[mx][my];
                map[mx][my] = -1;
                mx = mx+dx[dir];
                my = my+dy[dir];
                go++;
                if(go==turn){
                    go=0;
                    up++;
                    dir = dir-1;
                    if(dir==-1){
                        dir=3;
                    }else if(dir==4){
                        dir=0;
                    }
                }
                if(turn==n-1){
                    if(up==3){
                        up=0;
                        turn--;
                    }
                }else{
                    if(up==2){
                        up=0;
                        turn--;
                    }
                }
                map[mx][my] = dir;
                if(mx==n/2&&my==n/2){//중심에 도달하면 시계
                    dir = 3;
                    map[mx][my] = dir;
                    md=1;
                    turn = 1;
                    up=0;
                    go=0;
                }

            }
            //잡음
            int cnt =0;
            int dir = map[mx][my];
            for (int i = 0; i <3; i++) {
                int nx = mx + i*dx[dir];
                int ny = my + i*dy[dir];
                if(nx<0||ny<0||nx>=n||ny>=n)continue; //범위밖
                if(tree[nx][ny]==0){//나무 없으면
                    for (int j = 0; j <person[nx][ny].size(); j++) {
                        cnt++;//잡음
                    }
                    person[nx][ny].clear();
                }
            }
            score += cnt*size;
            if(size==k){
                System.out.println(score);
                break;
            }
        }
    }
}

