import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<score.length;i++){
            pq.add(score[i]);
        }
        int[] count = new int[k+1];
        int size = score.length/m;
        while(size-->0){
            for(int i=0;i<m;i++){
                int num = pq.poll();
                if(i==m-1){
                    count[num]++;
                }
            }
        }
        for(int i=1;i<k+1;i++){
            answer += i*m*count[i];
        }
        return answer;
    }
}
