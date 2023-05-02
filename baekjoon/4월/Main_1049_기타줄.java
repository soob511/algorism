package greedy;

import java.io.*;
import java.util.*;

public class Main_1049_기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] set = new int[m];
        int[] each = new int[m];
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            set[i] = Integer.parseInt(st.nextToken());
            each[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(set);
        Arrays.sort(each);
        int num = n/6;
        int num2 = n%6;
        int sum= set[0]*num+each[0]*num2;

        int sum2=Math.min(set[0]*(num+1),each[0]*n);

        System.out.println(Math.min(sum,sum2));
    }
}
