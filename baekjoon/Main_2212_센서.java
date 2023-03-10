package greedy;

import java.io.*;
import java.util.*;

public class Main_2212_센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensor = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);
        int[] dis = new int[n-1];
        for (int i = 0; i <n-1; i++) {
            dis[i] = sensor[i+1] - sensor[i];
        }
        Arrays.sort(dis);

        int sum = 0;
        for (int i = 0; i <n-k; i++) {
            sum+=dis[i];
        }
        System.out.println(sum);

    }
}
