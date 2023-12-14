import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] num = new int[201];
        for(int i=0;i<lines.length;i++){
            for(int j = lines[i][0]; j<lines[i][1];j++){
                num[j+100] +=1;
            }
        }
         for(int i=0;i<=200;i++){
            if(num[i]>1){
                answer++;
            }
        }
        return answer;
    }
}
