package Priority_queue;

import java.io.*;
import java.util.*;

public class Main_1202_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] jewels = new int[n][2];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0]= Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewels, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int[] bags = new int[k];
        for (int i = 0; i <k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int start = 0;
        long sum = 0;
        for (int i = 0; i <k; i++) {
            for (int j=start;j<n;j++){
                if(jewels[j][0]<=bags[i]){
                    pq.add(jewels[j][1]);
                    start=j+1;
                }else {
                    break;
                }
            }
            if (!pq.isEmpty()){
                sum+=pq.poll();
            }
        }
        System.out.println(sum);
    }
}
