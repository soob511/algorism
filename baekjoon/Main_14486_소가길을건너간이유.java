package implement;

import java.io.*;
import java.util.*;

public class Main_14486_소가길을건너간이유 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
//        for(int[] b:arr) System.out.println(Arrays.toString(b));
//        System.out.println();
        int result = arr[0][0] + arr[0][1];
        for(int i=1;i<n;i++){
            if(result<=arr[i][0]){
                result = arr[i][0]+arr[i][1];
            }else if (result>arr[i][0]){
                result += arr[i][1];
            }
        }
        System.out.println(result);
    }
}
