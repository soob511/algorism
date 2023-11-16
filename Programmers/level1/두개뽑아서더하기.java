import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){
                if(i==j)continue;
                pq.add(numbers[i]+numbers[j]);
            }
        }
        int n = -1;
        List<Integer> list = new LinkedList<>();
        while(!pq.isEmpty()){
            int m = pq.poll(); 
            if(n!=m){
                n = m;
                list.add(m);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
