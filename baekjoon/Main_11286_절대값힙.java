package Priority_queue;

import java.io.*;
import java.util.*;
public class Main_11286_절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue <Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1)>Math.abs(o2)){
                    return Math.abs(o1)-Math.abs(o2);
                }else if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }else{
                    return -1;//음수이면 바꾸지 않음 양수면 바꿈
                }
            }
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else{
                    System.out.println(0);
                }
            }else{
                pq.add(x);
            }
        }
    }
}
