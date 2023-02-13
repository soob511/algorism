package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2271_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] k = new int[n];
        for (int i = 0; i <n; i++) {
            k[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(k);
        int max = 0;
        for (int i = 0; i <n; i++) {
            int sum=0;
            sum += k[i]*(n-i);
            max = Math.max(sum,max);
        }
        System.out.println(max);
    }
}
