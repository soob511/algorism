package Samsung;

import java.util.*;
import java.io.*;

public class Main_19238_스타트택시 {
    static int n, m, f;
    static int[][] map;
    static int tx, ty;
    static int[][] people;
    static boolean[] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean result = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());//초기연료량

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        tx = Integer.parseInt(st.nextToken()) - 1;
        ty = Integer.parseInt(st.nextToken()) - 1;

        people = new int[m][4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()) - 1;//손님x
            people[i][1] = Integer.parseInt(st.nextToken()) - 1;//손님y
            people[i][2] = Integer.parseInt(st.nextToken()) - 1;//도착지x
            people[i][3] = Integer.parseInt(st.nextToken()) - 1;//도착지 y
        }
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        visit = new boolean[m];
        int size = m;
        while (size-- > 0) {
            int min = Integer.MAX_VALUE;
            int num = -1;
            for (int i = 0; i < m; i++) {//제일가까운 승객 찾기
                if (!visit[i]) {
                    int dist = shortdist(tx, ty, people[i][0], people[i][1]);
                    if (dist >= 0 && dist <= f && dist < min) {
                        min = dist;
                        num = i;
                    }
                }
            }
            if (num == -1) {//태울 승객이 없음
                result = false;
                break;
            }
            //승객위치로 이동
            tx = people[num][0];
            ty = people[num][1];
            f -= min;
            if (f <= 0) { //연료 떨어지면
                result = false;
                break;
            }
            //승객이동
            int dist = shortdist(tx, ty, people[num][2], people[num][3]);
            if(dist>=0&&dist<=f){
                f -= dist;
                if (f < 0) {
                    result = false;
                    break;
                }
                //승객이동성공
                visit[num] = true;
                f += dist * 2;
                tx = people[num][2];
                ty = people[num][3];
            }else{//길을 못찾음
                result = false;
                break;
            }

        }
        if (result) {
            System.out.println(f);
        } else {
            System.out.println(-1);
        }


    }

    private static int shortdist(int tx, int ty, int px, int py) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{tx, ty, 0});
        boolean[][] visited = new boolean[n][n];
        visited[tx][ty] = true;
        int time = -1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (px == p[0] && py == p[1]) {
                time = p[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || map[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, p[2] + 1});
            }
        }
        return time;
    }
}