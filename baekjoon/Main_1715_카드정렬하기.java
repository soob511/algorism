package Priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }
        int result = 0;
        while (pq.size()>1){
            int sum = 0;
            sum = pq.poll() + pq.poll();
            pq.add(sum);
            result += sum;
        }
        System.out.println(result);
    }
}
