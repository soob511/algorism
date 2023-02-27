package class3;

import java.io.*;
import java.util.*;

public class Main_11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <=n; i++) {
            arr[i] = + arr[i-1]+Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            sb.append(arr[J]-arr[I-1]+"\n");
        }
        System.out.println(sb);
    }
}
