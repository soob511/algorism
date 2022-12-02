import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        
//         int[] answer = new int[emergency.length];
//         int[] arr = new int[emergency.length];
//         Integer[] newarr = Arrays.stream(emergency).boxed().toArray(Integer[]::new); // 내림차순 정렬 Integer형으로 변환
        
//         for(int i=0;i<emergency.length;i++){
//             arr[i] = emergency[i];
//         }
        
//         Arrays.sort(newarr,Collections.reverseOrder());
        
//         for(int i=0;i<emergency.length;i++){
//             for(int j=0;j<emergency.length;j++){
//                 if(arr[i]==newarr[j]){
//                     answer[i] = j+1;
//                 }
//             }
//         }
//         return answer;
        
         int[] answer = new int[emergency.length];
           for(int i=0;i<emergency.length;i++){
               int c = 1;
            for(int j=0;j<emergency.length;j++){
                if(emergency[i]<emergency[j]){
                    c++;
                }
            }
                    answer[i] = c;
        }
        return answer;
    }
}
