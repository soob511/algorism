import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        
        for(int i=0;i<array.length;i++){
            if(array[i]<=n){
                continue;
            }else{
                int a = n-array[i-1];
                int b = array[i]-n;
                if(a<=b){
                    answer = array[i-1];
                    return answer;
                }else{
                    answer = array[i];
                    return answer;
                }
            }
            
        }
        answer = array[array.length-1];
        return answer;
    }
}
