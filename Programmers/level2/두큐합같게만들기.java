import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long one = 0;
        long two = 0;
        for(int i=0;i<queue1.length;i++){
            one += queue1[i];
            q1.add(queue1[i]);
            two += queue2[i];
            q2.add(queue2[i]);
        }
        if((one+two)%2==1){
            return -1;
        }
        while(true){
            if(q1.isEmpty()||q2.isEmpty()||answer>queue1.length*4){
                return -1;
            }
            if(one==two){
                return answer;
            }
            if(one>two){
                answer++;
                int num = q1.poll();
                q2.add(num);
                one-=num;
                two+=num;
            }else{
                answer++;
                 int num = q2.poll();
                 q1.add(num);
                 one+=num;
                 two-=num;
            }
        }
    }
}
