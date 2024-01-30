import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<order.length;i++){
            q.add(i+1);
        }
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<order.length;i++){
            while(true){
                if(!q.isEmpty()&&q.peek()==order[i]){
                    q.poll();
                    answer++;
                    break;
                }else if(!s.isEmpty()&&s.peek()==order[i]){
                    s.pop();
                    answer++;
                    break;
                }else if(!q.isEmpty()){
                    s.push(q.poll());
                }else{
                    return answer;
                }
            }
        }
        return answer;
    }
}
