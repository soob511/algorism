package greedy;

import java.io.*;
import java.util.*;

public class Main_1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j <n; j++) {
            a[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j <n; j++) {
            b[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b,Comparator.reverseOrder());
        int s = 0;
        for (int i = 0; i <n; i++) {
            s+=a[i]*b[i];
        }
        System.out.println(s);
    }
}
