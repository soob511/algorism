package Priority_queue;

import java.io.*;
import java.util.*;

public class Main_1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxq = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxq.size() == minq.size()) {
                maxq.add(num);
            } else {
                minq.add(num);
            }
            if (!maxq.isEmpty() && !minq.isEmpty()) {
                if (maxq.peek() > minq.peek()) {
                    int temp = maxq.poll();
                    maxq.add(minq.poll());
                    minq.add(temp);
                }
            }
           sb.append(maxq.peek()+"\n");
        }
        System.out.println(sb);
    }

}
