package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_15686_치킨배달 {
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> list,chicken;
    static int result = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        list = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    list.add(new int[]{i, j});
                } else if(map[i][j]==2){
                    chicken.add(new int[]{i,j});
                }
            }
        }
        visit = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(result);

    }

    private static void dfs(int count, int idx) {
        if(count==m){
            int sum = 0;
            for (int i = 0; i <list.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j <chicken.size(); j++) {
                    if (visit[j]){
                        int dist =  Math.abs(list.get(i)[0] - chicken.get(j)[0]) + Math.abs(list.get(i)[1] - chicken.get(j)[1]);
                        min = Math.min(dist,min);
                    }
                }
                sum+=min;
            }
            result = Math.min(result,sum);
            return;
        }
        for (int i=idx;i<chicken.size();i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(count+1,i+1);
                visit[i] =false;
            }
        }

    }
}
