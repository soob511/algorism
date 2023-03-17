import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] visit = new boolean[reserve.length];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    answer++;
                    lost[i] = -1;
                    visit[j] = true;
                    break;
                }
            }
        }
    
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
               if(lost[i]-1==reserve[j]||lost[i]+1==reserve[j]){
                    if(!visit[j]){
                    visit[j] = true;
                    answer++;
                    break;
                    }
                }
            }
        }
        return answer;
    }
}