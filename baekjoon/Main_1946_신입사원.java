package greedy;

import java.util.*;
import java.io.*;

public class Main_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t <tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][2];
            for (int i = 0; i <n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(map, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            int select = map[0][1];
            int count= 1;
            for (int i = 1; i <n; i++) {
                if(map[i][1]<select){
                    select = map[i][1];
                    count++;
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
