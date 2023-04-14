package topointer;

import java.io.*;
import java.util.*;

public class Main_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        int count=0;
        int sum=0;
        while (true){
            if(sum>=m){
                sum-=arr[l];
                l++;
            }else if(r==n){
                break;
            }
            else if(sum<m){
                sum+=arr[r];
                r++;
            }
            if(sum==m){
                count++;
            }
        }
        System.out.println(count);
    }
}
