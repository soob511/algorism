package backtracking;

import java.io.*;
import java.util.*;

public class Main_6603_로또 {
    static int[] map;
    static boolean[] visit;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0){
                break;
            }
            map = new int[n];
            visit = new boolean[n];
            for (int i = 0; i <n; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }
            per(0,0);
            System.out.println();
        }
    }

    private static void per(int start, int cnt) {
        if(cnt==6){
            for (int i = 0; i <n; i++) {
                if(visit[i]){
                    System.out.print(map[i]+" ");
                }
            }
            System.out.println();
        }
        for (int i = start; i <n; i++) {
                visit[i] = true;
                per(i+1,cnt+1);
                visit[i] = false;
        }
    }
}
