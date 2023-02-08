package Priority_queue;

import java.io.*;
import java.util.*;

public class Main_11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else {
                    System.out.println(0);
                }
            }else{
                pq.add(x);
            }
        }

    }
}
